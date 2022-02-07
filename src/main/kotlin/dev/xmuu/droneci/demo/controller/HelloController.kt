package dev.xmuu.droneci.demo.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    private val logger = LoggerFactory.getLogger(javaClass)

    @RequestMapping("/")
    fun index(): String {
        logger.info("Hello World")
        return "Hello, world!"
    }

}