package cz.capgemini.javateam.exception

/**
 * Always have fun, no exceptions
 */
class FunException(message: String, errorType: FunErrorType) : RuntimeException(message) {
    var issueType: FunErrorType = errorType
}