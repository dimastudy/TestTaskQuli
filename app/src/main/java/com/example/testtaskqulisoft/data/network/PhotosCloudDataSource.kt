package com.example.testtaskqulisoft.data.network

import com.example.testtaskqulisoft.data.PhotoData
import com.example.testtaskqulisoft.data.mappers.ResultNetworkToPhotoDataMapper
import javax.inject.Inject

class PhotosCloudDataSource @Inject constructor(
    private val api: PhotoApi,
    private val networkToDataMapper: ResultNetworkToPhotoDataMapper
) : CloudDataSource {
    override suspend fun fetchPhotos(
        query: String, page: Int,
        perPage: Int
    ): List<PhotoData> {
        return api.getPhotos(query = query, page = page, perPage = perPage).results.map { result ->
            result.mapToPhotoData(networkToDataMapper)
        }
    }
}