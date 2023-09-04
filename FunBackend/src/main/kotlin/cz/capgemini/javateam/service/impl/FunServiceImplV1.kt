package cz.capgemini.javateam.service.impl

import cz.capgemini.javateam.annotation.Fun
import cz.capgemini.javateam.dto.ProductLookAlike
import cz.capgemini.javateam.dto.fromDto
import cz.capgemini.javateam.repository.entity.SomeProductRepository
import cz.capgemini.javateam.service.FunService
import org.springframework.stereotype.Service

/**
 * Service providing data. Nothing surprising.
 */
@Service
@Fun
class FunServiceImplV1(private val someProductRepository: SomeProductRepository) : FunService {

    override fun getSomeProducts(): List<ProductLookAlike> {
        return someProductRepository.findAll().map { fromDto(it) }
    }
}