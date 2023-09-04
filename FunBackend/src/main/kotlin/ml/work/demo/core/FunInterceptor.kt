package ml.work.demo.core

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import ml.work.demo.dto.Surprise
import org.springframework.web.servlet.HandlerInterceptor

/**
 * Makes sure there is even more fun
 */
class FunInterceptor(
    private val counter: FunCounter,
    private val funServiceProvider: FunServiceProvider
) : HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        counter.hits++
        if (counter.hits.mod(5) == 0) {
            funServiceProvider.getFunContext().getBean(Surprise::class.java)
                .prepareSurprise("Surprise answer for the fifth caller")
        }
        return true
    }
}