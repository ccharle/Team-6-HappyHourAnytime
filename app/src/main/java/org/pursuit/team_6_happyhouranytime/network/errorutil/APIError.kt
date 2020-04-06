package org.pursuit.team_6_happyhouranytime.network.errorutil

class APIError : ErrorUtils() {
    var errorMessage: (() -> String)? = null
    var statusCode: (() -> Int)? = null

    fun transmitError(): String {
        return errorMessage.toString()

    }
}
