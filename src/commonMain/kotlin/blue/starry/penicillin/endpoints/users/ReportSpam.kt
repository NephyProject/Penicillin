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

package blue.starry.penicillin.endpoints.users

import blue.starry.penicillin.core.request.action.JsonObjectApiAction
import blue.starry.penicillin.core.request.formBody
import blue.starry.penicillin.core.session.post
import blue.starry.penicillin.endpoints.Option
import blue.starry.penicillin.endpoints.Users
import blue.starry.penicillin.models.User

/**
 * Report the specified user as a spam account to Twitter. Additionally, optionally performs the equivalent of [POST blocks/create](https://developer.twitter.com/en/docs/accounts-and-users/mute-block-report-users/api-reference/post-blocks-create) on behalf of the authenticated user.
 * 
 * [Twitter API reference](https://developer.twitter.com/en/docs/accounts-and-users/mute-block-report-users/api-reference/post-users-report_spam)
 * 
 * @param screenName The screen_name of the user to report as a spammer. Helpful for disambiguating when a valid screen name is also a user ID.
 * @param performBlock Whether the account should be blocked by the authenticated user, as well as being reported for spam.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Users] endpoint instance.
 * @return [JsonObjectApiAction] for [User] model.
 */
public fun Users.reportSpamByScreenName(
    screenName: String,
    performBlock: Boolean? = null,
    vararg options: Option
): JsonObjectApiAction<User> = reportSpam(screenName, null, performBlock, *options)

/**
 * Report the specified user as a spam account to Twitter. Additionally, optionally performs the equivalent of [POST blocks/create](https://developer.twitter.com/en/docs/accounts-and-users/mute-block-report-users/api-reference/post-blocks-create) on behalf of the authenticated user.
 *
 * [Twitter API reference](https://developer.twitter.com/en/docs/accounts-and-users/mute-block-report-users/api-reference/post-users-report_spam)
 *
 * @param userId The ID of the user to report as a spammer. Helpful for disambiguating when a valid user ID is also a valid screen name.
 * @param performBlock Whether the account should be blocked by the authenticated user, as well as being reported for spam.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Users] endpoint instance.
 * @return [JsonObjectApiAction] for [User] model.
 */
public fun Users.reportSpamByUserId(
    userId: Long,
    performBlock: Boolean? = null,
    vararg options: Option
): JsonObjectApiAction<User> = reportSpam(null, userId, performBlock, *options)

private fun Users.reportSpam(
    screenName: String? = null,
    userId: Long? = null,
    performBlock: Boolean? = null,
    vararg options: Option
) = client.session.post("/1.1/users/report_spam.json") {
    formBody(
        "screen_name" to screenName,
        "user_id" to userId,
        "perform_block" to performBlock,
        *options
    )
}.jsonObject { User(it, client) }
