package com.sistemalima.bank.application.ports.inputs

import com.sistemalima.bank.domain.Accounting

interface AccountingUseCase {

    fun execute(accounting: Accounting)
}