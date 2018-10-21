@file:Suppress("UNUSED")

package jp.nephy.penicillin.models

import jp.nephy.jsonkt.ImmutableJsonObject
import jp.nephy.jsonkt.delegation.*


data class Guest(override val json: ImmutableJsonObject): PenicillinModel {
    val guestToken by string("guest_token")
}
