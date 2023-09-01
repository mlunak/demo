package cz.capgemini.javateam.service.impl

import cz.capgemini.javateam.annotation.Fun
import cz.capgemini.javateam.dto.ProductLookAlike
import cz.capgemini.javateam.dto.Surprise
import cz.capgemini.javateam.service.FunService
import org.springframework.stereotype.Service
import java.math.BigDecimal

/**
 * whatever
 */
@Service
@Fun("v2")
class FunServiceImplV2(
    private val surpriseBean: Surprise
) : FunService {

    override fun getSomeProducts(): List<ProductLookAlike> {
        return listOf(
            ProductLookAlike(
                1,
                surpriseBean.getSurprise() ?: "Leaf Rake",
                "GDN-0011",
                "March 19, 2021",
                "Leaf rake with 48-inch wooden handle.",
                BigDecimal.valueOf(19.95),
                BigDecimal.valueOf(3.2),
                "assets/images/leaf_rake.png"
            ),
            ProductLookAlike(
                2,
                surpriseBean.getSurprise() ?: "Garden Cart",
                "GDN-0023",
                "March 18, 2021",
                "15 gallon capacity rolling garden cart",
                BigDecimal.valueOf(32.01),
                BigDecimal.valueOf(4.4),
                "assets/images/v.png"
            )
        )
    }
}