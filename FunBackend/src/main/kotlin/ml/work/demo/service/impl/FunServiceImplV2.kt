package ml.work.demo.service.impl

import ml.work.demo.annotation.Fun
import ml.work.demo.dto.ProductLookAlike
import ml.work.demo.dto.Surprise
import ml.work.demo.dto.fromDtoSurprise
import ml.work.demo.repository.entity.SomeProductRepository
import ml.work.demo.service.FunService
import org.springframework.stereotype.Service

/**
 * Service providing data but
 */
@Service
@Fun("v2")
class FunServiceImplV2(
    private val surpriseBean: Surprise,
    private val someProductRepository: SomeProductRepository
) : FunService {

    override fun getSomeProducts(): List<ProductLookAlike> {
        return someProductRepository.findAll().map { fromDtoSurprise(it, surpriseBean.getSurprise() ?: it.description) }
    }
}