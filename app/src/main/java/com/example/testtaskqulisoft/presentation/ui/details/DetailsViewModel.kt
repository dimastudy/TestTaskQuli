package com.example.testtaskqulisoft.presentation.ui.details

import androidx.lifecycle.*
import com.example.testtaskqulisoft.domain.PhotoDomain
import dagger.assisted.AssistedInject


class DetailsViewModel(
    private val photo: PhotoDomain
) : ViewModel() {

    private val photoLiveData = MutableLiveData<String?>()

    fun observePhoto(lifecycleOwner: LifecycleOwner, observer: Observer<String?>){
        photoLiveData.observe(lifecycleOwner, observer)
    }

    init {
        photoLiveData.value = photo.photoFullLink
    }

    class DetailsFactory(
        private val photo: PhotoDomain
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetailsViewModel::class.java)){
                return DetailsViewModel(photo) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }


}