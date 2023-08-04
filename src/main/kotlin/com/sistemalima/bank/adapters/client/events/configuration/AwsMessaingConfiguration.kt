package com.sistemalima.bank.adapters.client.events.configuration

import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.services.sqs.AmazonSQSAsync
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.aws.messaging.config.QueueMessageHandlerFactory
import org.springframework.cloud.aws.messaging.config.SimpleMessageListenerContainerFactory
import org.springframework.cloud.aws.messaging.config.annotation.EnableSns
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.cloud.aws.messaging.listener.support.AcknowledgmentHandlerMethodArgumentResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.messaging.handler.annotation.support.HeadersMethodArgumentResolver
import org.springframework.messaging.handler.annotation.support.PayloadMethodArgumentResolver

@EnableSqs
@EnableSns
@Configuration
class AwsMessaingConfiguration(
    @Value("\${cloud.aws.region.static}")
    val region: String
) {

    @Bean
    @Primary
    fun queueMessagingTemplate(): QueueMessagingTemplate {
        return QueueMessagingTemplate(amazonSQSAsync())
    }

    @Bean
    @Primary
    fun amazonSQSAsync(): AmazonSQSAsync {
        return AmazonSQSAsyncClientBuilder
            .standard()
            .withRegion(region)
            .withCredentials(ProfileCredentialsProvider())
            //.withClientConfiguration(ClientConfiguration().withRetryPolicy(PredefinedRetryPolicies.getDefaultRetryPolicy()))
            .build()
    }

    @Bean
    @Primary
    fun simpleMessageListenerContainerFactory(amazonSQSAsync: AmazonSQSAsync): SimpleMessageListenerContainerFactory {
        return SimpleMessageListenerContainerFactory().apply {
            setAmazonSqs(amazonSQSAsync)
        }
    }

    @Bean
    @Primary
    fun queueMessageHandlerFactory(
        mapper: ObjectMapper,
        amazonSQSAsync: AmazonSQSAsync
    ): QueueMessageHandlerFactory {
        return QueueMessageHandlerFactory().apply {
            this.setAmazonSqs(amazonSQSAsync)
            this.setArgumentResolvers(
                listOf(
                    AcknowledgmentHandlerMethodArgumentResolver("Acknowledgment"),
                    HeadersMethodArgumentResolver(),
                    PayloadMethodArgumentResolver(MessageConverterConfiguration().mappingJackson2MessageConverter())
                )
            )
        }
    }

}