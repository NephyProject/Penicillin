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

import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import jp.nephy.penicillin.core.request.ApiRequest
import jp.nephy.penicillin.core.request.ApiRequestBuilder
import jp.nephy.penicillin.core.request.EndpointHost

private fun Session.call(
    method: HttpMethod, path: String, host: EndpointHost = EndpointHost.Default, protocol: URLProtocol = URLProtocol.HTTPS, builder: ApiRequestBuilder.() -> Unit = {}
): ApiRequest {
    return ApiRequestBuilder(this, method, protocol, host, path).apply(builder).build()
}

fun Session.get(path: String, host: EndpointHost = EndpointHost.Default, protocol: URLProtocol = URLProtocol.HTTPS, builder: ApiRequestBuilder.() -> Unit = {}): ApiRequest {
    return call(HttpMethod.Get, path, host, protocol, builder)
}

fun Session.post(path: String, host: EndpointHost = EndpointHost.Default, protocol: URLProtocol = URLProtocol.HTTPS, builder: ApiRequestBuilder.() -> Unit = {}): ApiRequest {
    return call(HttpMethod.Post, path, host, protocol, builder)
}

fun Session.put(path: String, host: EndpointHost = EndpointHost.Default, protocol: URLProtocol = URLProtocol.HTTPS, builder: ApiRequestBuilder.() -> Unit = {}): ApiRequest {
    return call(HttpMethod.Put, path, host, protocol, builder)
}

fun Session.patch(path: String, host: EndpointHost = EndpointHost.Default, protocol: URLProtocol = URLProtocol.HTTPS, builder: ApiRequestBuilder.() -> Unit = {}): ApiRequest {
    return call(HttpMethod.Patch, path, host, protocol, builder)
}

fun Session.delete(path: String, host: EndpointHost = EndpointHost.Default, protocol: URLProtocol = URLProtocol.HTTPS, builder: ApiRequestBuilder.() -> Unit = {}): ApiRequest {
    return call(HttpMethod.Delete, path, host, protocol, builder)
}

fun Session.head(path: String, host: EndpointHost = EndpointHost.Default, protocol: URLProtocol = URLProtocol.HTTPS, builder: ApiRequestBuilder.() -> Unit = {}): ApiRequest {
    return call(HttpMethod.Head, path, host, protocol, builder)
}

fun Session.options(path: String, host: EndpointHost = EndpointHost.Default, protocol: URLProtocol = URLProtocol.HTTPS, builder: ApiRequestBuilder.() -> Unit = {}): ApiRequest {
    return call(HttpMethod.Options, path, host, protocol, builder)
}