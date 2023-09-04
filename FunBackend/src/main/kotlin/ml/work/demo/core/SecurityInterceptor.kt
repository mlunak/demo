package ml.work.demo.core

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import ml.work.demo.exception.FunErrorType
import ml.work.demo.exception.FunException
import org.springframework.http.HttpMethod
import org.springframework.web.servlet.HandlerInterceptor

/**
 * Somehow handles additional security
 */
class SecurityInterceptor : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if (request.method == HttpMethod.OPTIONS.name()) { //if CORS request then OK
            return true
        }
        validateToken(request.getHeader("FunToken"))
        return true
    }

    private fun validateToken(token: String?) {
        if (token == null || token != "fun") {
            throw FunException("Wrong token", FunErrorType.SECURITY_ISSUE)
        }
    }
}