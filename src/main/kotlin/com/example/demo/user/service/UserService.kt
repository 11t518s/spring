package com.example.demo.user.service

import com.example.demo.entity.User
import com.example.demo.user.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {
    @Transactional
    fun createUser(name: String): User {
        val user = User(name = name)
        return userRepository.save(user)
    }

    @Transactional(readOnly = true)
    fun getUserByName(name: String): User? {
        return userRepository.findByName(name)
    }


    @Transactional(readOnly = true)
    fun getUserByNameWithScore(name: String): User? {
        return userRepository.findByName(name)
    }
}