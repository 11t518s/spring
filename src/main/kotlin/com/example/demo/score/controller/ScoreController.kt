package com.example.demo.score.controller

import com.example.demo.entity.Score
import com.example.demo.entity.User
import com.example.demo.score.dtos.GetStatsResponse
import com.example.demo.score.dtos.SaveScoreRequest
import com.example.demo.score.service.ScoreService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/score") // 기본 경로 설정
class ScoreController(
    private val scoreService: ScoreService
) {
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveScore(@Valid @RequestBody saveScoreRequest: SaveScoreRequest) {
        val newScore = Score(score = saveScoreRequest.score, user = User(id = saveScoreRequest.uid))
        scoreService.saveScore(newScore)
    }

    @GetMapping("/stats")
    fun getStats(): GetStatsResponse {
        val averageScore = scoreService.getAverageScore()
        val highestScore = scoreService.getHighestScore()
        return GetStatsResponse(
            averageScore = averageScore,
            highestScore = highestScore,
        )
    }

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNoSuchElementException(ex: NoSuchElementException): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ResponseEntity<String> {
        val error: FieldError? = ex.bindingResult.fieldErrors.firstOrNull()
        val errorMessage = error?.defaultMessage ?: "Invalid input"

        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }
}