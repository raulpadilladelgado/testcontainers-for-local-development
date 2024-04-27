package org.example.testcontainerslocaldevelopment

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.PostgreSQLContainer

@TestConfiguration(proxyBeanMethods = false)
class PostgresTestContainerConfiguration {
    @Bean
    @ServiceConnection
    fun postgresContainer() = PostgreSQLContainer("postgres:13")
}