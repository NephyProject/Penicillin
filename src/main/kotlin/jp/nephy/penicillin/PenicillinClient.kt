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

package jp.nephy.penicillin

import jp.nephy.penicillin.core.session.SessionBuilder
import jp.nephy.penicillin.endpoints.*
import kotlinx.io.core.Closeable

/**
 * Penicillin main client.
 * 
 * @param session Session configuration builder.
 * @constructor Creates new PenicillinClient with new Session.
 */
@Suppress("UNUSED")
class PenicillinClient(session: SessionBuilder.() -> Unit): Closeable {
    val session = SessionBuilder().apply(session).build()

    val account: Account
        get() = Account(this)
    val accountActivity: AccountActivity
        get() = AccountActivity(this)
    val activity: Activity
        get() = Activity(this)
    val application: Application
        get() = Application(this)
    val blocks: Blocks
        get() = Blocks(this)
    val cards: Cards
        get() = Cards(this)
    val collections: Collections
        get() = Collections(this)
    val collectionEntries: CollectionEntries
        get() = CollectionEntries(this)
    val directMessages: DirectMessages
        get() = DirectMessages(this)
    val directMessageEvent: DirectMessageEvents
        get() = DirectMessageEvents(this)
    val favorites: Favorites
        get() = Favorites(this)
    val followers: Followers
        get() = Followers(this)
    val followRequests: FollowRequests
        get() = FollowRequests(this)
    val friends: Friends
        get() = Friends(this)
    val friendships: Friendships
        get() = Friendships(this)
    val geo: Geo
        get() = Geo(this)
    val help: Help
        get() = Help(this)
    val livePipeline: LivePipeline
        get() = LivePipeline(this)
    val lists: Lists
        get() = Lists(this)
    val media: Media
        get() = Media(this)
    val misc: Misc
        get() = Misc(this)
    val moments: Moments
        get() = Moments(this)
    val mutes: Mutes
        get() = Mutes(this)
    val notifications: Notifications
        get() = Notifications(this)
    val oauth: OAuth
        get() = OAuth(this)
    val oauth2: OAuth2
        get() = OAuth2(this)
    val savedSearches: SavedSearches
        get() = SavedSearches(this)
    val search: Search
        get() = Search(this)
    val statuses: Statuses
        get() = Statuses(this)
    val stream: Stream
        get() = Stream(this)
    val timeline: Timeline
        get() = Timeline(this)
    val trends: Trends
        get() = Trends(this)
    val users: Users
        get() = Users(this)
    val welcomeMessages: WelcomeMessages
        get() = WelcomeMessages(this)
    val welcomeMessageRules: WelcomeMessageRules
        get() = WelcomeMessageRules(this)

    override fun close() {
        session.close()
    }
}
