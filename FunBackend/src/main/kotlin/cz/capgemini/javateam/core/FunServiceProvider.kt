package cz.capgemini.javateam.core

import cz.capgemini.javateam.annotation.Fun
import cz.capgemini.javateam.exception.FunErrorType
import cz.capgemini.javateam.exception.FunException
import cz.capgemini.javateam.service.FunService
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

/**
 * Tries to provide some fun services for you
 */
@Component
class FunServiceProvider : ApplicationContextAware {

    private lateinit var applicationContext: ApplicationContext

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        this.applicationContext = applicationContext
    }

    fun getFun(version: String): FunService {
        val foundBeans = applicationContext.getBeansWithAnnotation(Fun::class.java).filterValues {
            val annotation = it.javaClass.getAnnotation(Fun::class.java)
            annotation.version.equals(version, ignoreCase = true)
        }
        if (foundBeans.isEmpty()) {
            //just get any
            return applicationContext.getBeansWithAnnotation(Fun::class.java).values.stream()
                .findAny()
                .orElseThrow { FunException("No version of fun", FunErrorType.A_BIT_OF_AN_ISSUE) } as FunService
        }
        return foundBeans.values.stream().findFirst().get() as FunService
    }

    fun getFunContext(): ApplicationContext = this.applicationContext
}