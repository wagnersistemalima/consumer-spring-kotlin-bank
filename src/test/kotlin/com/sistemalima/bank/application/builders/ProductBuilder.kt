package com.sistemalima.bank.application.builders

import com.sistemalima.bank.domain.Accounting

object ProductBuilder {

    fun create(): Accounting.Product {
        return Accounting.Product(
            productCode = "654",
            description = "produto super mix"
        )
    }
}