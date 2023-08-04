package com.sistemalima.bank.adapters.client.events.queue

import com.sistemalima.bank.adapters.client.events.queue.entity.AccountingEntity
import org.springframework.cloud.aws.messaging.listener.Acknowledgment
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.stereotype.Component

@Component
class SqsAccountingConsumer {

    @SqsListener(value = ["\${cloud.aws.queue.processor}"], deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    fun accountingMyFilaConsumer(
        accountingEntity: AccountingEntity,
        acknowledgment: Acknowledgment
    ) {

        println()
        acknowledgment.acknowledge()

    }
}