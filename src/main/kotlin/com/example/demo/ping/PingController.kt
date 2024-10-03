package com.example.demo.ping

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/ping")
@RestController
class PingController {
    @GetMapping("")
    fun pingPongTest(@Value("\${fixed.value.pong}") keyword: String ): String {
        return keyword
    }
}