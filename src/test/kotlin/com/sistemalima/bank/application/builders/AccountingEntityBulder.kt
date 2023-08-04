package com.sistemalima.bank.application.builders

import com.sistemalima.bank.adapters.client.events.queue.entity.AccountingEntity

object AccountingEntityBulder {

    fun create(): AccountingEntity {
        return AccountingEntity(
            accountingId = "123456",
            statusCode = "ACTIVE",
            product = createProductEntity(),
            transactions = createTransactionEntity(),
            registeredAt = "10/07/2023",
            totalRecords = 3
        )
    }

    private fun createProductEntity(): AccountingEntity.ProductEntity {
        return AccountingEntity.ProductEntity(
            productCode = "654",
            description = "produto super mix"
        )
    }

    private fun createTransactionEntity(): List<AccountingEntity.TransactionEntity> {
        val transactionEntity1 = AccountingEntity.TransactionEntity(
            externalAccountCode = "78986",
            personDocumentId = "65498732145",
            transactionCode = "45",
            transactionValue = "65.60",
            transactionDescription = "compra avista",
            eventType = "pagamento"
        )

        val transactionEntity2 = AccountingEntity.TransactionEntity(
            externalAccountCode = "78987",
            personDocumentId = "65498732146",
            transactionCode = "46",
            transactionValue = "45.60",
            transactionDescription = "compra avista",
            eventType = "pagamento"
        )

        val transactionEntity3 = AccountingEntity.TransactionEntity(
            externalAccountCode = "78988",
            personDocumentId = "65498732147",
            transactionCode = "47",
            transactionValue = "35.60",
            transactionDescription = "compra avista",
            eventType = "pagamento"
        )

        return listOf(transactionEntity1, transactionEntity2, transactionEntity3)
    }
}