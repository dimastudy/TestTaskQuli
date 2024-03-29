package com.example.testtaskqulisoft.data.network


import com.example.testtaskqulisoft.data.PhotoData
import com.example.testtaskqulisoft.data.mappers.ResultNetworkToPhotoDataMapper
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("blur_hash")
    val blurHash: String,
    @SerializedName("color")
    val color: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("current_user_collections")
    val currentUserCollections: List<Any>,
    @SerializedName("description")
    val description: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("liked_by_user")
    val likedByUser: Boolean,
    @SerializedName("likes")
    val likes: Int,
    @SerializedName("links")
    val links: Links,
    @SerializedName("urls")
    val urls: Urls,
    @SerializedName("user")
    val user: User,
    @SerializedName("width")
    val width: Int
) {

    fun mapToPhotoData(mapper: ResultNetworkToPhotoDataMapper) : PhotoData = mapper.map(id, urls.full, urls.small, user.username, description)

}