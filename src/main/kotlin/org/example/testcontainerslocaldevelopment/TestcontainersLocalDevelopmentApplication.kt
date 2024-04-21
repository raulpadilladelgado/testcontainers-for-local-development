package org.example.testcontainerslocaldevelopment

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.shell.command.annotation.EnableCommand

@SpringBootApplication
@EnableCommand(SongsController::class)
class TestcontainersLocalDevelopmentApplication

fun main(args: Array<String>) {
    runApplication<TestcontainersLocalDevelopmentApplication>(*args)
}
