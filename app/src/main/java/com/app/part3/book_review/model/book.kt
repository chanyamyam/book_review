package com.app.part3.book_review.model

import com.google.gson.annotations.SerializedName

data class book(
    @SerializedName("itemId") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("coverSmallUrl") val coverSmallUrl: String
)
