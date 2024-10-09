package com.example.demo.score.service

import com.example.demo.entity.Score
import com.example.demo.score.repository.JpaScoreRepository
import org.springframework.stereotype.Service

@Service
class ScoreService(
    private val scoreRepository: JpaScoreRepository
) {
    fun saveScore(score: Score) {
        if (score.score < 0) {
            throw IllegalArgumentException("0보다 작을 수 없습니다.")
        }
        if (score.score > 100) {
            throw IllegalArgumentException("100보다 클 수 없습니다.")
        }
        scoreRepository.save(score)
    }

    fun getHighestScore(): Int {
        val highestScore = scoreRepository.findHighestScore()
        return highestScore
    }

    fun getAverageScore(): Double {
        val averageScore = scoreRepository.findAverageScore()
        return averageScore
    }
}