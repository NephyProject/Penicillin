@file:Suppress("UNUSED")

package jp.nephy.penicillin.endpoints

import jp.nephy.penicillin.PenicillinClient
import jp.nephy.penicillin.models.CursorIds
import jp.nephy.penicillin.models.CursorUsers
import jp.nephy.penicillin.models.User

class Block(override val client: PenicillinClient): Endpoint {
    fun listIds(stringifyIds: Boolean? = null, vararg options: Pair<String, Any?>) = client.session.get("/1.1/blocks/ids.json") {
        parameter("stringify_ids" to stringifyIds, *options)
    }.cursorJsonObject<CursorIds>()

    fun list(includeEntities: Boolean? = null, skipStatus: Boolean? = null, vararg options: Pair<String, Any?>) = client.session.get("/1.1/blocks/list.json") {
        parameter("include_entities" to includeEntities, "skip_status" to skipStatus, *options)
    }.cursorJsonObject<CursorUsers>()

    fun create(screenName: String? = null, userId: Long? = null, includeEntities: Boolean? = null, skipStatus: Boolean? = null, vararg options: Pair<String, Any?>) =
        client.session.post("/1.1/blocks/create.json") {
            body {
                form {
                    add("screen_name" to screenName, "user_id" to userId, "include_entities" to includeEntities, "skip_status" to skipStatus, *options)
                }
            }
        }.jsonObject<User>()

    fun destroy(screenName: String? = null, userId: Long? = null, includeEntities: Boolean? = null, skipStatus: Boolean? = null, vararg options: Pair<String, Any?>) =
        client.session.post("/1.1/blocks/destroy.json") {
            body {
                form {
                    add("screen_name" to screenName, "user_id" to userId, "include_entities" to includeEntities, "skip_status" to skipStatus, *options)
                }
            }
        }.jsonObject<User>()
}
