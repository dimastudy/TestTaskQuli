package com.example.testtaskqulisoft.data

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.testtaskqulisoft.data.mappers.PhotoDataToDomainMapper
import com.example.testtaskqulisoft.data.network.CloudDataSource
import com.example.testtaskqulisoft.data.network.PhotoPagingSource
import com.example.testtaskqulisoft.domain.PhotoDomain
import com.example.testtaskqulisoft.domain.Repository
import javax.inject.Inject

class PhotosRepository @Inject constructor(
    private val cloudDataSource: CloudDataSource,
    private val dataToDomainMapper: PhotoDataToDomainMapper
) : Repository {
    override fun fetchPhotos(query: String): LiveData<PagingData<PhotoDomain>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { PhotoPagingSource(cloudDataSource, query, dataToDomainMapper) }
        ).liveData
    }
}