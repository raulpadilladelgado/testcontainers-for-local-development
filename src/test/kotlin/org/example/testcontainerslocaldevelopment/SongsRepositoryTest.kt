package org.example.testcontainerslocaldevelopment

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@Testcontainers
@SpringBootTest
class SongsRepositoryTest {
    @Autowired
    private lateinit var repository: SongsRepository

    companion object {
        @Container
        private val posgresContainer = PostgreSQLContainer("postgres:13")

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", posgresContainer::getJdbcUrl)
            registry.add("spring.datasource.username", posgresContainer::getUsername)
            registry.add("spring.datasource.password", posgresContainer::getPassword)
        }
    }

    @Test
    fun `should create and list songs`() {
        repository.create(Song("Song 1", "Artist 1"))
        repository.create(Song("Song 2", "Artist 2"))
        repository.create(Song("Song 3", "Artist 3"))

        val songs = repository.list()

        assertEquals(3, songs.size)
        assertEquals(Song("Song 1", "Artist 1"), songs[0])
        assertEquals(Song("Song 2", "Artist 2"), songs[1])
        assertEquals(Song("Song 3", "Artist 3"), songs[2])
    }
}