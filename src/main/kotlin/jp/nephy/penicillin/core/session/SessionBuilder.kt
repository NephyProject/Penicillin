/*
 * The MIT License (MIT)
 *
 *     Copyright (c) 2017-2019 Nephy Project Team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

@file:Suppress("UNUSED")

package jp.nephy.penicillin.core.session

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.features.HttpPlainText
import io.ktor.client.features.cookies.AcceptAllCookiesStorage
import io.ktor.client.features.cookies.HttpCookies
import io.ktor.client.features.cookies.addCookie
import io.ktor.http.Cookie
import io.ktor.util.KtorExperimentalAPI
import jp.nephy.penicillin.core.auth.Credentials
import jp.nephy.penicillin.core.emulation.EmulationMode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext

class SessionBuilder {
    private var credentialsBuilder: Credentials.Builder.() -> Unit = {}
    fun account(initializer: Credentials.Builder.() -> Unit) {
        credentialsBuilder = initializer
    }

    var emulationMode = EmulationMode.None
    private var skipEmulationChecking = false
    fun skipEmulationChecking() {
        skipEmulationChecking = true
    }

    var maxRetries = 3
    private var retryInMillis = 3000L
    fun retry(interval: Long, unit: TimeUnit) {
        retryInMillis = unit.toMillis(interval)
    }

    private var defaultTimeoutInMillis = 5000L
    fun defaultTimeout(timeout: Long, unit: TimeUnit) {
        defaultTimeoutInMillis = unit.toMillis(timeout)
    }

    private var dispatcherConfigBuilder: DispatcherConfig.Builder.() -> Unit = {}
    fun dispatcher(builder: DispatcherConfig.Builder.() -> Unit) {
        dispatcherConfigBuilder = builder
    }

    data class DispatcherConfig(val coroutineContext: CoroutineContext, val connectionThreadsCount: Int?) {
        class Builder {
            var connectionThreadsCount: Int? = null
            var coroutineContext: CoroutineContext = Dispatchers.Default

            internal fun build(): DispatcherConfig {
                return DispatcherConfig(coroutineContext, connectionThreadsCount)
            }
        }
    }

    private var cookieConfigBuilder: CookieConfig.Builder.() -> Unit = {}
    fun cookie(builder: CookieConfig.Builder.() -> Unit) {
        cookieConfigBuilder = builder
    }

    data class CookieConfig(val acceptCookie: Boolean, val cookies: Map<String, List<Cookie>>) {
        class Builder {
            private var acceptCookie = false
            fun acceptCookie() {
                acceptCookie = true
            }

            private val cookies = mutableMapOf<String, MutableList<Cookie>>()
            fun addCookie(host: String, cookie: Cookie) {
                if (host !in cookies) {
                    cookies[host] = mutableListOf(cookie)
                } else {
                    cookies[host]!!.add(cookie)
                }
            }

            internal fun build(): CookieConfig {
                return CookieConfig(acceptCookie, cookies)
            }
        }
    }

    private var httpClientEngineFactory: HttpClientEngineFactory<*>? = null
    private var httpClientConfig: HttpClientConfig<*>.() -> Unit = {}
    @Suppress("UNCHECKED_CAST")
    fun <T: HttpClientEngineConfig> httpClient(engineFactory: HttpClientEngineFactory<T>, block: HttpClientConfig<T>.() -> Unit = {}) {
        httpClientEngineFactory = engineFactory
        httpClientConfig = block as HttpClientConfig<*>.() -> Unit
    }

    fun httpClient(block: HttpClientConfig<*>.() -> Unit = {}) {
        httpClientConfig = block
    }

    private var httpClient: HttpClient? = null
    fun httpClient(client: HttpClient) {
        httpClient = client
    }

    @UseExperimental(KtorExperimentalAPI::class)
    internal fun build(): Session {
        val cookieConfig = CookieConfig.Builder().apply(cookieConfigBuilder).build()
        val dispatcherConfig = DispatcherConfig.Builder().apply(dispatcherConfigBuilder).build()
        val httpClient = httpClient ?: if (httpClientEngineFactory != null) HttpClient(httpClientEngineFactory!!) else HttpClient()
        httpClient.config {
            install(HttpPlainText) {
                defaultCharset = Charsets.UTF_8
            }

            if (cookieConfig.acceptCookie) {
                install(HttpCookies) {
                    storage = AcceptAllCookiesStorage()

                    if (cookieConfig.cookies.isNotEmpty()) {
                        runBlocking {
                            for ((key, value) in cookieConfig.cookies) {
                                for (cookie in value) {
                                    storage.addCookie(key, cookie)
                                }
                            }
                        }
                    }
                }
            }

            if (dispatcherConfig.connectionThreadsCount != null) {
                engine {
                    threadsCount = dispatcherConfig.connectionThreadsCount
                }
            }

            httpClientConfig.invoke(this)
        }
        val authorizationData = Credentials.Builder().apply(credentialsBuilder).build()
        val logger = KotlinLogging.logger("Penicillin.Client")

        return Session(
            httpClient,
            dispatcherConfig.coroutineContext,
            logger,
            authorizationData,
            ClientOption(maxRetries, retryInMillis, defaultTimeoutInMillis, emulationMode, skipEmulationChecking)
        )
    }
}
