package com.sistemalima.bank.adapters.client.events.queue.entity

data class AccountingEntity(
    val accountingId: String,
    val statusCode: String,
    val product: ProductEntity,
    val transactions: List<TransactionEntity>,
    val registeredAt: String,
    val totalRecords: Int
){
    data class ProductEntity(
        val productCode: String,
        val description: String
    )

    data class TransactionEntity(
        val externalAccountCode: String,
        val personDocumentId: String,
        val transactionCode: String,
        val transactionValue: String,
        val transactionDescription: String,
        val eventType: String
    )
}
