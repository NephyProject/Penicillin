package jp.nephy.penicillin.models

import com.google.gson.JsonObject
import jp.nephy.jsonkt.byLong
import jp.nephy.jsonkt.byString


data class UserStreamScrubGeo(override val json: JsonObject): PenicillinModel {
    val userId by json["scrub_geo"].byLong("user_id")
    val userIdStr by json["scrub_geo"].byString("user_id_str")
    val upToStatusId by json["scrub_geo"].byLong("up_to_status_id")
    val upToStatusIdStr by json["scrub_geo"].byString("up_to_status_id_str")
    val timestampMs by json["scrub_geo"].byString("timestamp_ms")
}
