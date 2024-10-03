package com.example.demo.score.repository

import com.example.demo.score.models.Score

interface ScoreRepository {
    fun save(score: Score)
    fun findAll(): List<Score>
}