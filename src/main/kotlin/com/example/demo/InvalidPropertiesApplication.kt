package com.example.demo

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootApplication
class InvalidPropertiesApplication

fun main(args: Array<String>) {
    runApplication<InvalidPropertiesApplication>(*args)
}
@Configuration
class UsersInitializer {

    @Bean
    fun users() = Users()

    @Bean
    fun runner(users: Users) = CommandLineRunner { _ ->
        println("users: $users")
    }
}

@ConfigurationProperties(
        prefix = "users",
        ignoreInvalidFields = true,
        ignoreUnknownFields = true
)
data class Users(
        var file: String? = null
)