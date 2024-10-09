package com.example.demo.score.repository

import com.example.demo.entity.Score


interface ScoreRepository {
    fun save(score: Score)
    fun findAll(): List<Score>
}