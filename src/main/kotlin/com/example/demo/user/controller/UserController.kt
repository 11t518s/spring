package com.example.demo.user.controller

import com.example.demo.entity.User
import com.example.demo.user.dtos.CreateUserRequest
import com.example.demo.user.dtos.CreateUserResponse
import com.example.demo.user.dtos.GetUserResponse
import com.example.demo.user.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user") // 기본 경로 설정
class UserController(
    private val userService: UserService
) {
    @GetMapping("/{username}")
    fun getUser(@PathVariable username: String): ResponseEntity<GetUserResponse> {
        val user = userService.getUserByName(name = username) ?: throw NullPointerException("User not found")
        return ResponseEntity.ok(GetUserResponse(data = user))
    }

    @PostMapping
    fun createUser(@RequestBody body: CreateUserRequest): ResponseEntity<CreateUserResponse> {
        val createdUser = userService.createUser(name = body.name)

        return ResponseEntity.ok(CreateUserResponse(data = createdUser))
    }

}