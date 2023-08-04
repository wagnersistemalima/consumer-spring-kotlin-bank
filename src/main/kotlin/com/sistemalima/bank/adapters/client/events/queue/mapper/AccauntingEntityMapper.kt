package com.sistemalima.bank.adapters.client.events.queue.mapper

import com.sistemalima.bank.adapters.client.events.queue.entity.AccountingEntity
import com.sistemalima.bank.domain.Accounting

object AccauntingEntityMapper {

    fun AccountingEntity.toDomain(): Accounting {
        return Accounting(
            accountingId = this.accountingId,
            statusCode = this.statusCode,
            product = this.toProductDomain(),
            transactions = this.toDomain(this.transactions),
            registeredAt = this.registeredAt,
            totalRecords = this.totalRecords
        )
    }

    fun AccountingEntity.toDomain(transactionsEntity: List<AccountingEntity.TransactionEntity>): List<Accounting.Transaction> {
        return transactionsEntity.map {
            Accounting.Transaction(
                externalAccountCode = it.externalAccountCode,
                personDocumentId = it.personDocumentId,
                transactionCode = it.transactionCode,
                transactionValue = it.transactionValue,
                transactionDescription = it.transactionDescription,
                eventType = it.eventType
            )
        }
    }

    fun AccountingEntity.toProductDomain(): Accounting.Product {
        return Accounting.Product(
            productCode = this.product.productCode,
            description = this.product.description
        )
    }

}