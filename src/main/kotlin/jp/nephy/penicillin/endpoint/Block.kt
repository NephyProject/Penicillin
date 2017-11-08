package jp.nephy.penicillin.endpoint

import jp.nephy.penicillin.Client
import jp.nephy.penicillin.annotation.Cursorable
import jp.nephy.penicillin.annotation.GET
import jp.nephy.penicillin.annotation.POST
import jp.nephy.penicillin.model.CursorIds
import jp.nephy.penicillin.model.CursorUsers
import jp.nephy.penicillin.model.User
import jp.nephy.penicillin.response.ResponseObject

@Suppress("UNUSED")
class Block(private val client: Client) {
    @GET @Cursorable
    fun getIds(stringifyIds: Boolean?=null, vararg options: Pair<String, String?>): ResponseObject<CursorIds> {
        return client.session.new()
                .url("/blocks/ids.json")
                .param("stringify_ids" to stringifyIds)
                .params(*options)
                .get()
                .getResponseObject()
    }

    @GET @Cursorable
    fun getList(includeEntities: Boolean?=null, skipStatus: Boolean?=null, vararg options: Pair<String, String?>): ResponseObject<CursorUsers> {
        return client.session.new()
                .url("/blocks/list.json")
                .param("include_entities" to includeEntities)
                .param("skip_status" to skipStatus)
                .params(*options)
                .get()
                .getResponseObject()
    }

    @POST
    fun create(screenName: String?=null, userId: Long?=null, includeEntities: Boolean?=null, skipStatus: Boolean?=null, vararg options: Pair<String, String?>): ResponseObject<User> {
        return client.session.new()
                .url("/blocks/create.json")
                .dataAsForm("screen_name" to screenName)
                .dataAsForm("user_id" to userId)
                .dataAsForm("include_entities" to includeEntities)
                .dataAsForm("skip_status" to skipStatus)
                .dataAsForm(*options)
                .post()
                .getResponseObject()
    }

    @POST
    fun destroy(screenName: String?=null, userId: Long?=null, includeEntities: Boolean?=null, skipStatus: Boolean?=null, vararg options: Pair<String, String?>): ResponseObject<User> {
        return client.session.new()
                .url("/blocks/destroy.json")
                .dataAsForm("screen_name" to screenName)
                .dataAsForm("user_id" to userId)
                .dataAsForm("include_entities" to includeEntities)
                .dataAsForm("skip_status" to skipStatus)
                .dataAsForm(*options)
                .post()
                .getResponseObject()
    }
}