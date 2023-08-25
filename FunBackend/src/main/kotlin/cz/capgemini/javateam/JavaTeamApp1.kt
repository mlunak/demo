package cz.capgemini.javateam

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @author Capgemini
 */

@SpringBootApplication
@EnableAutoConfiguration
class JavaTeamApp1

fun main(args: Array<String>) {
    runApplication<JavaTeamApp1>(*args)
}