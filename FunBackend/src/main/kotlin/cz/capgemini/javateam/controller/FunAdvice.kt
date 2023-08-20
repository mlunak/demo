package cz.capgemini.javateam.controller

import cz.capgemini.javateam.dto.ValuableResponse
import cz.capgemini.javateam.exception.FunErrorType
import cz.capgemini.javateam.exception.FunException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * Handles exceptions
 */
@RestControllerAdvice
class FunAdvice {

    @ExceptionHandler(FunException::class)
    @ResponseBody
    fun handleException(funException: FunException): ResponseEntity<ValuableResponse> {
        if (funException.issueType == FunErrorType.SECURITY_ISSUE) {
            return ResponseEntity.of(ProblemDetail.forStatus(HttpStatus.UNAUTHORIZED.value())).build()
        } else if (funException.issueType == FunErrorType.A_BIT_OF_AN_ISSUE) {
            return ResponseEntity.internalServerError().body(ValuableResponse("Have to warn you for this one"))
        } else {
            return ResponseEntity.ok(ValuableResponse("You did something wrong but it's okay"))
        }
    }
}