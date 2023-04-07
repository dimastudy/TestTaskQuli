package com.example.testtaskqulisoft.domain.mappers

import com.example.testtaskqulisoft.data.mappers.PhotoDataToDomainMapper
import com.example.testtaskqulisoft.domain.PhotoDomain
import javax.inject.Inject

class BasePhotoDataToDomainMapper @Inject constructor() : PhotoDataToDomainMapper {
    override fun map(
        id: String,
        photoLink: String,
        photoSmallLink: String,
        photoCreatorUsername: String,
        photoDescription: String?
    ): PhotoDomain = PhotoDomain(id, photoLink, photoSmallLink,photoCreatorUsername, photoDescription ?: "Just a photo")
}