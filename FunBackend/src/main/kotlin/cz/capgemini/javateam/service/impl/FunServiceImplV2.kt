package cz.capgemini.javateam.service.impl

import cz.capgemini.javateam.Fun
import cz.capgemini.javateam.dto.Surprise
import cz.capgemini.javateam.service.FunService
import org.springframework.stereotype.Service

/**
 * whatever
 */
@Service
@Fun("v2")
class FunServiceImplV2(
    private val surpriseBean: Surprise
) : FunService {

    override fun getSomeInformation(): String {
        if (surpriseBean.getSurprise() != null) {
            return surpriseBean.getSurprise()!!
        }
        return "data from DB TODO"
    }

    override fun saveSomeInformation(information: String) {
        TODO("Not yet implemented")
    }
}