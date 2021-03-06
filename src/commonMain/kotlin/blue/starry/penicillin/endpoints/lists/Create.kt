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

package blue.starry.penicillin.endpoints.lists

import blue.starry.penicillin.core.request.action.JsonObjectApiAction
import blue.starry.penicillin.core.request.formBody
import blue.starry.penicillin.core.session.post
import blue.starry.penicillin.endpoints.Lists
import blue.starry.penicillin.endpoints.Option
import blue.starry.penicillin.models.TwitterList

/**
 * Creates a new list for the authenticated user. Note that you can create up to 1000 lists per account.
 * 
 * [Twitter API reference](https://developer.twitter.com/en/docs/accounts-and-users/create-manage-lists/api-reference/post-lists-create)
 * 
 * @param name The name for the list. A list's name must start with a letter and can consist only of 25 or fewer letters, numbers, "-", or "_" characters.
 * @param mode Whether your list is public or private. Values can be public or private . If no mode is specified the list will be public.
 * @param description The description to give the list.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Lists] endpoint instance.
 * @return [JsonObjectApiAction] for [TwitterList] model.
 */
public fun Lists.create(
    name: String,
    mode: ListVisibilityMode = ListVisibilityMode.Default,
    description: String? = null,
    vararg options: Option
): JsonObjectApiAction<TwitterList> = client.session.post("/1.1/lists/create.json") {
    formBody(
        "name" to name,
        "mode" to mode,
        "description" to description,
        *options
    )
}.jsonObject { TwitterList(it, client) }
