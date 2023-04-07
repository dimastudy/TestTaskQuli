package com.example.testtaskqulisoft.data.network


import com.google.gson.annotations.SerializedName

data class NetworkResponse(
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)