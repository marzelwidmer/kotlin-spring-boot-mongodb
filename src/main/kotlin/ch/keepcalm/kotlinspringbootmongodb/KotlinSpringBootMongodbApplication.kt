package ch.keepcalm.kotlinspringbootmongodb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringBootMongodbApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringBootMongodbApplication>(*args)
}
