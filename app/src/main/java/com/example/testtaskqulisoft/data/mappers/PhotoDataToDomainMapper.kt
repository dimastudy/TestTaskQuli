package com.example.testtaskqulisoft.data.mappers

import com.example.testtaskqulisoft.domain.PhotoDomain

interface PhotoDataToDomainMapper {

    fun map(
        id: String,
        photoLink: String,
        photoSmallLink: String,
        photoCreatorUsername: String,
        photoDescription: String?
    ) : PhotoDomain

}