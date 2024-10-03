package com.example.demo.score.dtos
import javax.validation.constraints.Max
import javax.validation.constraints.Min

data class SaveScoreRequest(
    @field:Min(0, message = "점수는 0이상이어야 합니다.")
    @field:Max(100, message = "점수는 100이하여야 합니다.")
    val score: Int,
)
