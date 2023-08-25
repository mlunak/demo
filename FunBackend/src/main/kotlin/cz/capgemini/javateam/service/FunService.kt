package cz.capgemini.javateam.service

import cz.capgemini.javateam.dto.ProductLookAlike

/**
 * Service
 */

interface FunService {

    fun getSomeProducts(): List<ProductLookAlike>
}