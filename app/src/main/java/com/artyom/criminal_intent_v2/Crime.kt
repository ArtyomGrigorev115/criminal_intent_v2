package com.artyom.criminal_intent_v2

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity
data class Crime constructor(@PrimaryKey val id: UUID = UUID.randomUUID(), var title: String ="", var date: Date = Date(), var isSolved: Boolean = false) {
}