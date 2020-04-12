package org.pursuit.team_6_happyhouranytime.repository

import org.pursuit.team_6_happyhouranytime.network.errorutil.APIError

class Resource<T> private constructor(val status: Status, val data: T?, val apiError: APIError?) {

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(apiError: APIError?): Resource<T> {
            return Resource(Status.ERROR, null, apiError)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}
