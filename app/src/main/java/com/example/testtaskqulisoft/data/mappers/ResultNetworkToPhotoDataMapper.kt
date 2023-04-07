package com.example.testtaskqulisoft.data.mappers

import com.example.testtaskqulisoft.data.PhotoData
import javax.inject.Inject

interface ResultNetworkToPhotoDataMapper {

    fun map(
        id: String,
        photoLink: String,
        photoSmallLink: String,
        photoCreatorUsername: String,
        photoDescription: String?
    ) : PhotoData


    class Base @Inject constructor() : ResultNetworkToPhotoDataMapper {
        override fun map(
            id: String,
            photoLink: String,
            photoSmallLink: String,
            photoCreatorUsername: String,
            photoDescription: String?
        ): PhotoData = PhotoData(id, photoLink, photoSmallLink,photoCreatorUsername, photoDescription)

    }

}