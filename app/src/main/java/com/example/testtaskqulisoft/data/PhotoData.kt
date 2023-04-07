package com.example.testtaskqulisoft.data

import com.example.testtaskqulisoft.data.mappers.PhotoDataToDomainMapper
import com.example.testtaskqulisoft.domain.PhotoDomain

data class PhotoData(
    private val id: String,
    private val photoFullLink: String,
    private val photoSmallLink: String,
    private val photoCreatorUsername: String,
    private val photoDescription: String?
) {

    fun mapToPhotoDomain(mapper: PhotoDataToDomainMapper): PhotoDomain =
        mapper.map(id, photoFullLink, photoSmallLink,photoCreatorUsername, photoDescription)

}