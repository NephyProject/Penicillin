package jp.nephy.penicillin.models

import com.google.gson.JsonObject
import jp.nephy.jsonkt.byLong
import jp.nephy.jsonkt.byString

class Contributor(override val json: JsonObject): PenicillinModel {
    val id by json.byLong
    val idStr by json.byString("id_str")
    val screenName by json.byString("screen_name")
}