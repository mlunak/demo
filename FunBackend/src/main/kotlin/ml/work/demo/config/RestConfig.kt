package ml.work.demo.config

import ml.work.demo.core.FunCounter
import ml.work.demo.core.FunInterceptor
import ml.work.demo.core.FunServiceProvider
import ml.work.demo.core.SecurityInterceptor
import ml.work.demo.logging.LoggingInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
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
        registry.addInterceptor(LoggingInterceptor())
    }

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedMethods("*")
            .allowedOriginPatterns("http://*:[4201]")
            .maxAge(1_800L)
    }
}