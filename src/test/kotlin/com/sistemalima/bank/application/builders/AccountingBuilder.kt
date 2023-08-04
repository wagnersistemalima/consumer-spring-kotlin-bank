package com.sistemalima.bank.application.builders

import com.sistemalima.bank.domain.Accounting

object AccountingBuilder {

    fun create(): Accounting {
        return Accounting(
            accountingId = "123456",
            statusCode = "ACTIVE",
            product = ProductBuilder.create(),
            transactions = TransactionsBuilder.create(),
            registeredAt = "10/07/2023",
            totalRecords = 3
        )
    }
}