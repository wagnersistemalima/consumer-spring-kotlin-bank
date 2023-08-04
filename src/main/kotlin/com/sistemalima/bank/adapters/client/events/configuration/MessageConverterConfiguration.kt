package com.sistemalima.bank.adapters.client.events.configuration

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.messaging.converter.MappingJackson2MessageConverter

class MessageConverterConfiguration {

    fun mappingJackson2MessageConverter(): MappingJackson2MessageConverter {
        val mappingJackson2MessageConverter = MappingJackson2MessageConverter()
        mappingJackson2MessageConverter.objectMapper = objectMapper()
        mappingJackson2MessageConverter.objectMapper = objectMapper()
        mappingJackson2MessageConverter.serializedPayloadClass = String::class.java
        mappingJackson2MessageConverter.isStrictContentTypeMatch = false
        return mappingJackson2MessageConverter
    }

    private fun objectMapper(): ObjectMapper {
        val mapper = jacksonObjectMapper()
        mapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES)
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        mapper.disable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE)
        mapper.disable(SerializationFeature.WRAP_ROOT_VALUE)
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        mapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE)
        mapper.setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE)
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
        mapper.registerModule(JavaTimeModule())
        mapper.registerModule(SimpleModule())
        return mapper
    }
}