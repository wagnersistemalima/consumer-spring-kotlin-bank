package com.sistemalima.bank.domain

data class TransactionSubmission(
    val tranckingId: String,
    val description: String,
    val amount: String
)
