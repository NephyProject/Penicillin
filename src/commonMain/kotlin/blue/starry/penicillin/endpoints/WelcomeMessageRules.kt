/*
 * The MIT License (MIT)
 *
 *     Copyright (c) 2017-2020 StarryBlueSky
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

package blue.starry.penicillin.endpoints

import blue.starry.penicillin.core.session.ApiClient
import blue.starry.penicillin.core.session.ApiClientDsl

/**
 * Returns [WelcomeMessageRules] endpoint instance.

 * [Twitter API reference](https://developer.twitter.com/en/docs/direct-messages/welcome-messages/overview)
 *
 * @return New [WelcomeMessageRules] endpoint instance.
 * @receiver Current [ApiClient] instance.
 */
@ApiClientDsl
val ApiClient.welcomeMessageRules: WelcomeMessageRules
    get() = WelcomeMessageRules(this)

/**
 * Collection of api endpoints related to Welcome Message Rules.
 *
 * @constructor Creates new [WelcomeMessageRules] endpoint instance.
 * @param client Current [ApiClient] instance.
 * @see ApiClient.welcomeMessageRules
 */
class WelcomeMessageRules(override val client: ApiClient): Endpoint