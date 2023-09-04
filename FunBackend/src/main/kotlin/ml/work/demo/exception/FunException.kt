package ml.work.demo.exception

/**
 * Always have fun, no exceptions
 */
class FunException(message: String, errorType: FunErrorType) : RuntimeException(message) {
    var issueType: FunErrorType = errorType
}