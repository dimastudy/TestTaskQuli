package com.example.testtaskqulisoft.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApi {

    @GET("search/photos")
    suspend fun getPhotos(
        @Query("client_id") client_id: String = CLIENT_ID,
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ) : NetworkResponse


    companion object {
        private const val CLIENT_ID = "ab3411e4ac868c2646c0ed488dfd919ef612b04c264f3374c97fff98ed253dc9"
        const val BASE_URL = "https://api.unsplash.com/"
    }

}