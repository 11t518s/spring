package com.example.demo.score.service

import com.example.demo.score.models.Score

interface ScoreService {
    fun saveScore(score: Score)
    fun getHighestScore(): Int
    fun getAverageScore(): Double
}