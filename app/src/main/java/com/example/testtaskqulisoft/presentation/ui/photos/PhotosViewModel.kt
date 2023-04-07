package com.example.testtaskqulisoft.presentation.ui.photos

import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.example.testtaskqulisoft.domain.PhotoDomain
import com.example.testtaskqulisoft.domain.usercases.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase
) : ViewModel() {

    private val photoQuery = MutableLiveData<String>()

    val photosData = photoQuery.switchMap {query ->
        getPhotosUseCase(query).cachedIn(viewModelScope)
    }


    fun fetchPhotos(query: String) {
        viewModelScope.launch {
            photoQuery.value = query
        }
    }

}