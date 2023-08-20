package cz.capgemini.javateam.core

import cz.capgemini.javateam.exception.FunErrorType
import cz.capgemini.javateam.exception.FunException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.servlet.HandlerInterceptor

/**
 * Somehow handles security
 */
class SecurityInterceptor : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        validateToken(request.getHeader("FunToken"))
        return true
    }

    private fun validateToken(token: String?) {
        if (token == null || token != "fun") {
            throw FunException("Wrong token", FunErrorType.SECURITY_ISSUE)
        }
    }
}