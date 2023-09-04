package ml.work.demo.logging

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.util.StopWatch
import org.springframework.web.servlet.HandlerInterceptor

/**
 * Logs and other things
 */
class LoggingInterceptor(
) : HandlerInterceptor {

    companion object {
        private val logger = LoggerFactory.getLogger(LoggingInterceptor::class.java)
        private val sw = StopWatch()
    }

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        sw.start()
        return true
    }

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        sw.stop()
        logger.debug("EXECUTION TOOK: ${sw.totalTimeSeconds} seconds")
        if (ex != null) {
            logger.debug("EXCEPTION: $ex")
        }
    }
}