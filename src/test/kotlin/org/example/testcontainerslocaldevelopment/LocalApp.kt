package org.example.testcontainerslocaldevelopment

import org.springframework.boot.fromApplication

fun main(args: Array<String>) {
    fromApplication<TestcontainersLocalDevelopmentApplication>()
        .with(TestContainersConfiguration::class.java)
        .run(*args)
}
