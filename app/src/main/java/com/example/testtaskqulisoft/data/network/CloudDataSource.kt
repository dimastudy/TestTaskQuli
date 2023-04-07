package com.example.testtaskqulisoft.data.network

import com.example.testtaskqulisoft.data.PhotoData
import retrofit2.http.Query

interface CloudDataSource {

    suspend fun fetchPhotos(
        query: String,
        page: Int,
        perPage: Int
    ): List<PhotoData>

}