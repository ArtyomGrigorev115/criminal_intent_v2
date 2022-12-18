package com.artyom.criminal_intent_v2

import java.util.Date
import java.util.UUID

data class Crime constructor(val id: UUID = UUID.randomUUID(), var title: String ="", var date: Date = Date(), var isSolved: Boolean = false) {
}