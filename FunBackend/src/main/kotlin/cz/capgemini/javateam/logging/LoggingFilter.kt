package cz.capgemini.javateam.logging

import jakarta.servlet.FilterChain
import jakarta.servlet.annotation.WebFilter
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.MDC
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.util.ContentCachingRequestWrapper
import org.springframework.web.util.ContentCachingResponseWrapper
import java.nio.charset.StandardCharsets
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.floor

/**
 * Purpose of this class is to log request and response to any single HTTP request
 * {@link MDC} is provided with a value reflected in console/file logs
 */
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Component
@WebFilter(filterName = "LoggingFilter", urlPatterns = ["/*"])
class LoggingFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        MDC.put("callChainId", orDefaultCallChainId(request.getHeader("FunCallChainId")))

        val req = ContentCachingRequestWrapper(request)
        val resp = ContentCachingResponseWrapper(response)

        filterChain.doFilter(req, resp)

        logger.info("REQUEST INFO: {\"method\": ${request.method}, \"uri\": \"${request.requestURI}\"}")
        logger.info("REQUEST HEADER: ${bufferHeaders(request)}")
        logger.info("REQUEST DATA: ${String(req.contentAsByteArray, StandardCharsets.UTF_8)}");
        logger.info("RESPONSE DATA:${String(resp.contentAsByteArray, StandardCharsets.UTF_8)}}")

        resp.copyBodyToResponse()
    }

    private fun orDefaultCallChainId(callChainId: String?): String {
        return callChainId ?: ("FBE" + ZonedDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + floor(Math.random() * 10_000))
    }

    private fun bufferHeaders(request: HttpServletRequest): String {
        val sb = StringBuilder()
        sb.append("{")
        for (hn in request.headerNames) {
            sb.append("\"${hn}\": \"${request.getHeaders(hn).nextElement()}\",")
        }
        sb.trimEnd(',')
        sb.append("}")
        return sb.toString()
    }
}