package com.sistemalima.bank.domain

import java.time.LocalDateTime
import java.util.UUID

data class Observability(
    val accountId: String,
    val correlationId: String = UUID.randomUUID().toString(),
    val dateTime: String = LocalDateTime.now().toString()
)
