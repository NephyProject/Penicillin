package jp.nephy.penicillin.model

import com.google.gson.JsonObject
import jp.nephy.jsonkt.byModel


class UserStreamListEvent(json: JsonObject): UserStreamEvent(json) {
    val targetObject by json.byModel<TwitterList>(key = "target_object")
}
