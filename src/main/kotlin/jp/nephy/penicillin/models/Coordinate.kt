@file:Suppress("UNUSED")

package jp.nephy.penicillin.models

import jp.nephy.jsonkt.ImmutableJsonObject
import jp.nephy.jsonkt.delegation.floatList
import jp.nephy.jsonkt.delegation.lambda
import jp.nephy.jsonkt.delegation.string

data class Coordinate(override val json: ImmutableJsonObject): PenicillinModel {
    val coordinates by floatList
    val type by string

    val longitude by lambda {
        if (coordinates.size == 2) {
            coordinates[0]
        } else {
            null
        }
    }
    val latitude by lambda {
        if (coordinates.size == 2) {
            coordinates[1]
        } else {
            null
        }
    }
}
