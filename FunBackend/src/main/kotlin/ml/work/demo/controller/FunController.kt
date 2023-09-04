package ml.work.demo.controller

import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import ml.work.demo.core.FunServiceProvider
import ml.work.demo.dto.ValuableResponse
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * Controller
 */
@RestController
class FunController(
    private val funServiceProvider: FunServiceProvider
) {

    @GetMapping(
        path = ["/rest/fun/{version}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Fun"),
            ApiResponse(responseCode = "401", description = "Serious issue"),
            ApiResponse(responseCode = "500", description = "Try again maybe")
        ]
    )
    fun get(
        @PathVariable version: String
    ): ResponseEntity<ValuableResponse> {
        val nuf = funServiceProvider.getFun(version)
        return ResponseEntity.ok(ValuableResponse(nuf.getSomeProducts()))
    }
}