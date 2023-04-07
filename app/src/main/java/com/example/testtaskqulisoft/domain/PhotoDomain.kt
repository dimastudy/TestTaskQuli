package com.example.testtaskqulisoft.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoDomain(
    val id: String,
    val photoFullLink: String,
    val photoSmallLink: String,
    val photoCreatorUsername: String,
    val photoDescription: String?
) : Parcelable {



}