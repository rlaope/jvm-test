package rlaope.jvmtest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JvmTestApplication

fun main(args: Array<String>) {
    runApplication<JvmTestApplication>(*args)
}
