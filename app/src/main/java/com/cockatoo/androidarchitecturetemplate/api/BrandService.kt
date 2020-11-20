package com.cockatoo.androidarchitecturetemplate.api

import com.cockatoo.androidarchitecturetemplate.model.response.BrandResponse
import retrofit2.Response
import retrofit2.http.GET

interface BrandService {

    @GET("/v1/brands")
    suspend fun getBrand() : Response<BrandResponse>

}