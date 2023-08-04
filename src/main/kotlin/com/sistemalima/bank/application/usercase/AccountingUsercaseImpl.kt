package com.sistemalima.bank.application.usercase

import com.sistemalima.bank.application.ports.inputs.AccountingUseCase
import com.sistemalima.bank.domain.Accounting
import org.springframework.stereotype.Component

@Component
class AccountingUsercaseImpl: AccountingUseCase {

    override fun execute(accounting: Accounting) {

        println()

    }
}