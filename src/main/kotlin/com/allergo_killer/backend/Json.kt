package com.allergo_killer.backend

import com.bedatadriven.jackson.datatype.jts.JtsModule
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component


@Component
class Json {
    @Bean
    @Primary
    fun objectMapper(): ObjectMapper? {
        return ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .registerModule(JavaTimeModule())
            .registerModule(JtsModule())
    }
}