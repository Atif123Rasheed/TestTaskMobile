package suvorov.testaskmobile.data.api

import retrofit2.http.GET
import suvorov.testaskmobile.data.model.CartApi
import suvorov.testaskmobile.data.model.ProductApi
import suvorov.testaskmobile.data.model.PhoneApi

interface ApiService {
    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getProducts(): ProductApi

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getPhone(): PhoneApi

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCart(): CartApi
}