package com.example.testtaskqulisoft.domain.usercases

import com.example.testtaskqulisoft.domain.Repository
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(query: String) = repository.fetchPhotos(query)
}