package cz.capgemini.javateam.repository

import cz.capgemini.javateam.repository.entity.SomeProduct
import cz.capgemini.javateam.repository.entity.SomeProductRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.time.LocalDateTime
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@SpringBootTest(classes = [TestConfig::class])
@Transactional
class RepositoryTest {

    @Autowired
    private lateinit var repo: SomeProductRepository

    @Test()
    fun test() {
        repo.save(
            SomeProduct(
                productName = "prod",
                productCode = "P2-GTR",
                releaseDate = LocalDateTime.now(),
                description = "deskr",
                price = BigDecimal.valueOf(17.82),
                starRating = BigDecimal.valueOf(1.1),
                imageUrl = "uareel"
            )
        )
        val all = repo.findAll()
        assertTrue(all.isNotEmpty())

        val product = repo.findByProductName(all[0].productName)
        assertNotNull(product)
    }
}