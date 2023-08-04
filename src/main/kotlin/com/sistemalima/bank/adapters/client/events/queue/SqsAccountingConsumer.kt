package com.sistemalima.bank.adapters.client.events.queue

import com.sistemalima.bank.adapters.client.events.queue.entity.AccountingEntity
import com.sistemalima.bank.adapters.client.events.queue.mapper.AccauntingEntityMapper.toDomain
import com.sistemalima.bank.application.ports.inputs.AccountingUseCase
import com.sistemalima.bank.domain.Observability
import org.slf4j.LoggerFactory
import org.springframework.cloud.aws.messaging.listener.Acknowledgment
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.stereotype.Component

@Component
class SqsAccountingConsumer(
    private val accountingUseCase: AccountingUseCase
) {

    private val logger = LoggerFactory.getLogger(SqsAccountingConsumer::class.java)

    @SqsListener(value = ["\${cloud.aws.queue.processor}"], deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    fun accountingMyFilaConsumer(
        accountingEntity: AccountingEntity,
        acknowledgment: Acknowledgment
    ) {

        val observability = Observability(
            accountId = accountingEntity.accountingId
        )

        try {

            logger.info( "${CLASS_NAME}, Inicio do consumo das informaçoes do accounting, $observability")

            val accounting = accountingEntity.toDomain()
            accountingUseCase.execute(accounting)

            logger.info( "${CLASS_NAME}, Fim do processamento das informaçoes do accounting, $observability")

        } catch (exception: Exception) {
            throw exception
        }

        println()
        acknowledgment.acknowledge()

    }

    companion object {
        private const val CLASS_NAME = "SqsAccountingConsumer"
    }
}