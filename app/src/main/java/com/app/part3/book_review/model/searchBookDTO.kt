package com.app.part3.book_review.model

import com.google.gson.annotations.SerializedName

data class searchBookDTO(
    @SerializedName("title") val title:String,
    @SerializedName("item") val books: List<book>
)
