package com.example.demo.user.repository

import com.example.demo.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.scores")
    fun findByName(name: String): User?
}