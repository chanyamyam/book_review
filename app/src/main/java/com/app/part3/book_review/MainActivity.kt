package com.app.part3.book_review

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.app.part3.book_review.api.bookService
import com.app.part3.book_review.model.bestSellerDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://book.interpark.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val bookService = retrofit.create(bookService::class.java)

        bookService.getBestSellerBooks("578E1222137342013B6E824AEAA6A34CCA8C6EBA7445C8A2DA171DCF4315A641")
                .enqueue(object: Callback<bestSellerDTO> {
                    override fun onResponse(call: Call<bestSellerDTO>, response: Response<bestSellerDTO>) {
                        if(response.isSuccessful.not()) {
                            Log.e(TAG,"Not!! SUCCESS")
                            return
                        }

                        response.body()?.let {
                            Log.d(TAG, it.toString())

                            it.books.forEach {
                                Log.d(TAG, it.toString())
                            }
                        }
                    }

                    override fun onFailure(call: Call<bestSellerDTO>, t: Throwable) {
                        Log.e(TAG,t.toString())
                    }

                })
    }
    companion object {
        private const val TAG = "MainActivity"
    }
}