package cz.capgemini.javateam.dto

import io.swagger.v3.oas.annotations.media.Schema

data class ValuableResponse(
    @field:Schema(description = "You know")
    val products: List<ProductLookAlike>?,
    @field:Schema(description = "Backup field")
    val responseForYou: String? = null
)
