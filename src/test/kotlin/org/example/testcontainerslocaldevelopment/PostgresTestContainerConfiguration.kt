package org.example.testcontainerslocaldevelopment

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer

@TestConfiguration
class PostgresTestContainerConfiguration {
    companion object {
        private val container: PostgreSQLContainer<*> = PostgreSQLContainer("postgres:latest").apply() {
            start()
        }

        @DynamicPropertySource
        @JvmStatic
        private fun configureDatasource(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", container::getJdbcUrl)
            registry.add("spring.datasource.username", container::getUsername)
            registry.add("spring.datasource.password", container::getPassword)
        }
    }
}