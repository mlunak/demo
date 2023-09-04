package ml.work.demo

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @author mlunak
 */

@SpringBootApplication
@EnableAutoConfiguration
class DemoJavaApp1

fun main(args: Array<String>) {
    runApplication<DemoJavaApp1>(*args)
}