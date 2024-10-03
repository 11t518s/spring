package com.example.demo.score.repository

import com.example.demo.score.models.Score
import org.springframework.stereotype.Repository

@Repository
class ScoreRepositoryImpl : ScoreRepository {
    private val scores = mutableListOf<Score>()

    override fun save(score: Score) {
        scores.add(score)
    }
    override fun findAll(): List<Score> {
        return scores
    }
}