package jp.nephy.penicillin.models

import com.google.gson.JsonObject
import jp.nephy.jsonkt.*


data class CardBindingValue(override val json: JsonObject): PenicillinModel {
    val choices by lazy {
        (1..5).filter { json.contains("choice${it}_label") }.map {
            json["choice${it}_label"]["string_value"].string to if (json.contains("choice${it}_count")) {
                json["choice${it}_count"]["string_value"].string.toInt()
            } else {
                0
            }
        }.toMap()
    }

    val isFinal by json["counts_are_final"].jsonObject.byBool("boolean_value")
    val endAt by json["end_datetime_utc"].jsonObject.byString("string_value")
    val updateAt by json["last_updated_datetime_utc"].jsonObject.byString("string_value")
    val minutes by json["duration_minutes"].jsonObject.byString("string_value")
}
