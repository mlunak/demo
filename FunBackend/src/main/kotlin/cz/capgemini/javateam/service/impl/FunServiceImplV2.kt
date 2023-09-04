package cz.capgemini.javateam.service.impl

import cz.capgemini.javateam.annotation.Fun
import cz.capgemini.javateam.dto.ProductLookAlike
import cz.capgemini.javateam.dto.Surprise
import cz.capgemini.javateam.dto.fromDtoSurprise
import cz.capgemini.javateam.repository.entity.SomeProductRepository
import cz.capgemini.javateam.service.FunService
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