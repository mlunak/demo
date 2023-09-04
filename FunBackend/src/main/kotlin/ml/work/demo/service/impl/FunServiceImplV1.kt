package ml.work.demo.service.impl

import ml.work.demo.annotation.Fun
import ml.work.demo.dto.ProductLookAlike
import ml.work.demo.dto.fromDto
import ml.work.demo.repository.entity.SomeProductRepository
import ml.work.demo.service.FunService
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