package com.cockatoo.androidarchitecturetemplate.data.remote

import com.cockatoo.androidarchitecturetemplate.api.BrandService
import com.cockatoo.androidarchitecturetemplate.model.Result
import com.cockatoo.androidarchitecturetemplate.model.response.BrandResponse
import com.cockatoo.androidarchitecturetemplate.util.ErrorUtils
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class BrandRemoteDataSource @Inject constructor(private val retrofit: Retrofit) {
    private val brandService = retrofit.create(BrandService::class.java)

    suspend fun fetchBrand() : Result<BrandResponse> {
        return getResponse(request = {brandService.getBrand()},
        defaultErrorMessage = "Error fetch brand")
    }

    private suspend fun <T> getResponse(request: suspend () -> Response<T>, defaultErrorMessage: String): Result<T> {
        return try {
            println("I'm working in thread ${Thread.currentThread().name}")
            val result = request.invoke()
            if (result.isSuccessful) {
                return Result.success(result.body())
            } else {
                val errorResponse = ErrorUtils.parseError(result, retrofit)
                Result.error(errorResponse?.status_message ?: defaultErrorMessage, errorResponse)
            }
        } catch (e: Throwable) {
            Result.error("Unknown Error", null)
        }
    }

}