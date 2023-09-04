package ml.work.demo.repository.entity

import jakarta.persistence.*
import org.springframework.data.domain.Persistable
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "some_products", schema = "funapp")
data class SomeProduct(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    val productId: Int? = null,

    @Column(name = "productname", nullable = false, length = 100)
    val productName: String,

    @Column(name = "productcode", nullable = false, length = 50)
    val productCode: String,

    @Column(name = "releasedate", nullable = false)
    val releaseDate: LocalDateTime,

    @Column(length = 200, nullable = false)
    val description: String,

    @Column(precision = 12, scale = 2, nullable = false)
    val price: BigDecimal,

    @Column(name = "starrating", precision = 3, scale = 2, nullable = false)
    val starRating: BigDecimal,

    @Column(name = "imageurl", length = 100, nullable = false)
    val imageUrl: String

) : Persistable<Int> {
    override fun getId(): Int? = productId

    override fun isNew(): Boolean = productId == null
}