package ml.work.demo.service

import ml.work.demo.dto.ProductLookAlike

/**
 * Service
 */

interface FunService {

    fun getSomeProducts(): List<ProductLookAlike>
}