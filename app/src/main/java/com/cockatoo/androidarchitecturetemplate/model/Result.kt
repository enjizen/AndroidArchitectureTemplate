package com.cockatoo.androidarchitecturetemplate.model

/**
 * Generic class for holding success response, error response and loading status
 */
data class Result<out T>(val status: Status, val data: T?, val error: Error?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): Result<T> = Result(Status.SUCCESS, data, null, null)

        fun <T> error(message: String, error: Error?): Result<T> = Result(Status.ERROR, null, error, message)

        fun <T> loading(data: T? = null): Result<T>  = Result(Status.LOADING, data, null, null)
    }

    override fun toString(): String = "Result(status=$status, data=$data, error=$error, message=$message)"
}