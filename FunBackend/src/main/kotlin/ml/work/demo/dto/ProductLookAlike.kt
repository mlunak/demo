package ml.work.demo.dto

import io.swagger.v3.oas.annotations.media.Schema
import ml.work.demo.repository.entity.SomeProduct
import java.math.BigDecimal
import java.time.format.DateTimeFormatter

data class ProductLookAlike(
    @field:Schema(description = "Peekay")
    val productId: Long,
    @field:Schema(description = "Name of it", maxLength = 400)
    val productName: String,
    @field:Schema(description = "Code", pattern = "[a-zA-Z]{3}-[0-9]{4}")
    val productCode: String,
    @field:Schema(description = "Formatted date", format = "date-time")
    val releaseDate: String,
    @field:Schema(description = "What")
    val description: String,
    @field:Schema(description = "The denero")
    val price: BigDecimal,
    @field:Schema(description = "TV star")
    val starRating: BigDecimal,
    @field:Schema(description = "Where to get the image")
    val imageUrl: String
)

fun fromDto(someProduct: SomeProduct): ProductLookAlike = ProductLookAlike(
    someProduct.productId!!.toLong(),
    someProduct.productName,
    someProduct.productCode,
    someProduct.releaseDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
    someProduct.description,
    someProduct.price,
    someProduct.starRating,
    someProduct.imageUrl
)

fun fromDtoSurprise(someProduct: SomeProduct, description: String): ProductLookAlike = ProductLookAlike(
    someProduct.productId!!.toLong(),
    someProduct.productName,
    someProduct.productCode,
    someProduct.releaseDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
    description,
    someProduct.price,
    someProduct.starRating,
    someProduct.imageUrl
)