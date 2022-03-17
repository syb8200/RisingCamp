package com.example.risingcamp.week5_hw

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    //Retrofit.Builder 클래스의 인스턴스를 만들고 Base URL을 구성해준다.
    val sRetrofit = initRetrofit()
    private const val RecommendPart_URL = "https://book.interpark.com/"

    private fun initRetrofit() : Retrofit =
        Retrofit.Builder()
            .baseUrl(RecommendPart_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}