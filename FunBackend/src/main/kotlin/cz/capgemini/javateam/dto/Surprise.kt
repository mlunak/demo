package cz.capgemini.javateam.dto

import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.RequestScope

/**
 * Someone may have some for you
 */
@Component
@RequestScope
class Surprise {
    private var surprise: String? = null

    fun getSurprise(): String? = surprise

    fun prepareSurprise(it: String) {
        this.surprise = it
    }
}