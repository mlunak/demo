package cz.capgemini.javateam.service.impl

import cz.capgemini.javateam.Fun
import cz.capgemini.javateam.dto.Surprise
import cz.capgemini.javateam.service.FunService
import org.springframework.stereotype.Service

/**
 * whatever
 */
@Service
@Fun
class FunServiceImplV1(private val surpriseBean: Surprise) : FunService {

    override fun getSomeInformation(): String {
        return "todo call databse"
    }

    override fun saveSomeInformation(information: String) {
        TODO("Not yet implemented")
    }
}