package com.example.demo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [InvalidPropertiesApplication::class])
@ActiveProfiles("test")
@TestPropertySource(locations = ["classpath:application.yml"])
class InvalidPropertiesApplicationTests(
        private val context: ApplicationContext
) {
    @Test
    fun contextLoads(@Autowired users: Users) {
        assertEquals("TEST", users.file)
    }

}
