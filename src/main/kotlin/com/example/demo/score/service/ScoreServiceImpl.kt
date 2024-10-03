package com.example.demo.score.service

import com.example.demo.score.models.Score
import com.example.demo.score.repository.ScoreRepository
import org.springframework.stereotype.Service

@Service
class ScoreServiceImpl(
    private val scoreRepository: ScoreRepository
) : ScoreService {
    override fun saveScore(score: Score) {
        scoreRepository.save(score)
    }

    override fun getHighestScore(): Int {
        val allScores = scoreRepository.findAll()
        return allScores.maxOfOrNull { it.score } ?: throw NoSuchElementException("아직 저장된 점수가 없습니다.")
    }

    override fun getAverageScore(): Double {
        val allScores = scoreRepository.findAll()
        if (allScores.isEmpty()) {
            throw NoSuchElementException("아직 저장된 점수가 없습니다.")
        }
        return allScores.map { it.score }.average()
    }

}