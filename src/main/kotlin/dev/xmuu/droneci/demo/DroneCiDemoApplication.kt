package dev.xmuu.droneci.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DroneCiDemoApplication

fun main(args: Array<String>) {
    runApplication<DroneCiDemoApplication>(*args)
}
