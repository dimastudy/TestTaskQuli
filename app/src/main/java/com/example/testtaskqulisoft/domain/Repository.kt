package com.example.testtaskqulisoft.domain

import androidx.lifecycle.LiveData
import androidx.paging.PagingData

interface Repository {

    fun fetchPhotos(query: String) : LiveData<PagingData<PhotoDomain>>

}