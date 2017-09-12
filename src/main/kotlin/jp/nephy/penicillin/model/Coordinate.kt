package jp.nephy.penicillin.model

import com.github.salomonbrys.kotson.byString
import com.google.gson.JsonElement
import jp.nephy.penicillin.converter.byFloatArray

class Coordinate(val json: JsonElement) {
    val coordinates by json.byFloatArray
    val type by json.byString

    val longitude = if (coordinates.size == 2) {
        coordinates[0]
    } else {
        null
    }
    val latitude = if (coordinates.size == 2) {
        coordinates[1]
    } else {
        null
    }
}