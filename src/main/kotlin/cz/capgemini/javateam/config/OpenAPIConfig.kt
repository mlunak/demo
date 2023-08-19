package cz.capgemini.javateam.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.Operation
import io.swagger.v3.oas.models.PathItem
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.media.StringSchema
import io.swagger.v3.oas.models.parameters.HeaderParameter
import io.swagger.v3.oas.models.servers.Server
import org.springdoc.core.customizers.OpenApiCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


/**
 * Configuration adding some information to OpenAPI
 */
@Configuration
class OpenAPIConfig() {

    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Our Open API")
                    .version("1")
            )
            .servers(
                listOf(
                    Server()
                        .url("localhost:6969")
                        .description("Your computer")
                )
            )
    }

    @Bean
    fun oneOpenAPICustomizer(): OpenApiCustomizer {
        return OpenApiCustomizer { openApi: OpenAPI ->
            openApi.paths.values.stream().flatMap { pathItem: PathItem ->
                pathItem.readOperations().stream()
            }
                .forEach { operation: Operation ->
                    operation.addParametersItem(
                        HeaderParameter()
                            .description("Security purposes")
                            .name("FunToken")
                            .required(true)
                            .schema(StringSchema())
                    )
                }
        }
    }
}