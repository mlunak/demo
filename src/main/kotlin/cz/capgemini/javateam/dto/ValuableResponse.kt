package cz.capgemini.javateam.dto

import io.swagger.v3.oas.annotations.media.Schema

data class ValuableResponse(
    @field:Schema(description = "You know", maxLength = 30000)
    val responseForYou: String
)
