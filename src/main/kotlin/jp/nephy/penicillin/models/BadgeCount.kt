@file:Suppress("UNUSED")

package jp.nephy.penicillin.models

import jp.nephy.jsonkt.ImmutableJsonObject
import jp.nephy.jsonkt.delegation.*


data class BadgeCount(override val json: ImmutableJsonObject): PenicillinModel {
    val dmUnreadCount by int("dm_unread_count")
    val ntabUnreadCount by int("ntab_unread_count")
    val totalUnreadCount by int("total_unread_count")
}
