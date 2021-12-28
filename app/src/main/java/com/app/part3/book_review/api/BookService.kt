package com.app.part3.book_review.api

import com.app.part3.book_review.model.bestSellerDTO
import com.app.part3.book_review.model.searchBookDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface bookService {

    @GET("/api/search.api?output=json")
    fun getBooksByName(
        @Query("key") apiKey: String,
        @Query("query") keyword: String
    ): Call<searchBookDTO>

    @GET("/api/bestSeller.api?output=json&categoryId=100")
    fun getBestSellerBooks(
        @Query("key") apiKey: String
    ): Call<bestSellerDTO>

}