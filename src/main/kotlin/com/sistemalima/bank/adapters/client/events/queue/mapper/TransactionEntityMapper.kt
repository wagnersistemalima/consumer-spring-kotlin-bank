package com.sistemalima.bank.adapters.client.events.queue.mapper

import com.sistemalima.bank.adapters.client.events.queue.entity.AccountingEntity
import com.sistemalima.bank.domain.Accounting

object TransactionEntityMapper {

    fun AccountingEntity.TransactionEntity.toDomain(transactionsEntity: List<AccountingEntity.TransactionEntity>): List<Accounting.Transaction> {
        return transactionsEntity.map {
            Accounting.Transaction(
                externalAccountCode = this.externalAccountCode,
                personDocumentId = this.personDocumentId,
                transactionCode = this.transactionCode,
                transactionValue = this.transactionValue,
                transactionDescription = this.transactionDescription,
                eventType = this.eventType
            )
        }
    }
}