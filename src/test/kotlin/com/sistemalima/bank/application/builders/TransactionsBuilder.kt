package com.sistemalima.bank.application.builders

import com.sistemalima.bank.domain.Accounting

object TransactionsBuilder {

    fun create(): List<Accounting.Transaction> {
        val transaction1 = Accounting.Transaction(
            externalAccountCode = "78986",
            personDocumentId = "65498732145",
            transactionCode = "45",
            transactionValue = "65.60",
            transactionDescription = "compra avista",
            eventType = "pagamento"
        )

        val transaction2 = Accounting.Transaction(
            externalAccountCode = "78987",
            personDocumentId = "65498732146",
            transactionCode = "46",
            transactionValue = "45.60",
            transactionDescription = "compra avista",
            eventType = "pagamento"
        )

        val transaction3 = Accounting.Transaction(
            externalAccountCode = "78988",
            personDocumentId = "65498732147",
            transactionCode = "47",
            transactionValue = "35.60",
            transactionDescription = "compra avista",
            eventType = "pagamento"
        )

        return listOf(transaction1, transaction2, transaction3)
    }
}