package com.sistemalima.bank.domain

data class Accounting(
    val accountingId: String,
    val statusCode: String,
    val product: Product,
    val transactions: List<Transaction>,
    val registeredAt: String,
    val totalRecords: Int

) {
    data class Product(
        val productCode: String,
        val description: String
    )

    data class Transaction(
        val externalAccountCode: String,
        val personDocumentId: String,
        val transactionCode: String,
        val transactionValue: String,
        val transactionDescription: String,
        val eventType: String
    )
}
