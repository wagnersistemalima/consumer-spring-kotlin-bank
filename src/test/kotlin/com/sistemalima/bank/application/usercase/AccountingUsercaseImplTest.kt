package com.sistemalima.bank.application.usercase

import com.sistemalima.bank.adapters.client.events.queue.mapper.AccauntingEntityMapper.toDomain
import com.sistemalima.bank.application.builders.AccountingEntityBulder
import com.sistemalima.bank.domain.Accounting
import com.sistemalima.bank.domain.TransactionSubmission
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
@ExtendWith(MockKExtension::class)
internal class AccountingUsercaseImplTest{

    @Test
    fun `deve mapear uma lista de transactions para uma lista de transactionSubmissions`() {

        /*
        A função map() permite transformar uma coleção em uma nova
         */

        // Dado
        val accountingEntity = AccountingEntityBulder.create()

        val accounting = accountingEntity.toDomain()


        // Quando

        // Então
        assertEquals(accounting.transactions[0].personDocumentId,accountingEntity.transactions[0].personDocumentId)
        assertEquals(accounting.transactions[1].personDocumentId, accountingEntity.transactions[1].personDocumentId)
        assertEquals(accounting.transactions[2].personDocumentId, accountingEntity.transactions[2].personDocumentId)
        assertEquals(accounting.totalRecords, accountingEntity.transactions.size)

    }

    private fun transactionToDomain(transactions: List<Accounting.Transaction>): List<TransactionSubmission> {

        return transactions.map {
            TransactionSubmission(
                tranckingId = it.personDocumentId,
                description = it.transactionDescription,
                amount = it.transactionValue
            )
        }

    }

}