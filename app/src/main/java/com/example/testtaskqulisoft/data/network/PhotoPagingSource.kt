package com.example.testtaskqulisoft.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.testtaskqulisoft.data.mappers.PhotoDataToDomainMapper
import com.example.testtaskqulisoft.domain.PhotoDomain

class PhotoPagingSource(
    private val dataSource: CloudDataSource,
    private val query: String,
    private val mapper: PhotoDataToDomainMapper
) : PagingSource<Int, PhotoDomain>() {
    override fun getRefreshKey(state: PagingState<Int, PhotoDomain>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotoDomain> {
        return try {
            val position = params.key ?: START_INDEX
            val data = dataSource.fetchPhotos(query, position, params.loadSize).map {
                it.mapToPhotoDomain(mapper)
            }
            LoadResult.Page(
                data = data,
                prevKey = if (position == START_INDEX) null else position - 1,
                nextKey = if (data.isEmpty()) null else position + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val START_INDEX = 1
    }
}