package com.example.demo.score.repository

import com.example.demo.entity.Score
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
@Primary
interface JpaScoreRepository : ScoreRepository, JpaRepository<Score, UUID> {
    @Query("select Max(score) from Score")
    fun findHighestScore(): Int

    @Query("select avg(score) from Score")
    fun findAverageScore(): Double

    override fun findAll(): List<Score>
}