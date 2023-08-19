package cz.capgemini.javateam.config

import cz.capgemini.javateam.core.FunCounter
import cz.capgemini.javateam.core.FunInterceptor
import cz.capgemini.javateam.core.FunServiceProvider
import cz.capgemini.javateam.core.SecurityInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * Rest configuration enabling MVC and registering interceptors {@link FunInterceptor}
 */
@Configuration
@EnableWebMvc
class RestConfig : WebMvcConfigurer {

    @Autowired
    private lateinit var funCounter: FunCounter

    @Autowired
    private lateinit var funServiceProvider: FunServiceProvider

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(FunInterceptor(funCounter, funServiceProvider))
        registry.addInterceptor(SecurityInterceptor())
    }
}