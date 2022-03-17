package com.example.risingcamp.week5_pt

import com.example.risingcamp.week5_pt.models.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherInterface {

    //@GET : GET 방식으로 데이터를 가져오겠다.
    //@Query : 쿼리값 2개 명시
    //getWeather의 반환타입을 WeatherResponse 타입의 Call 객체로 작성해준다.

    @GET("weather")
    fun getWeather(@Query("q") q:String,
                   @Query("appid") appid:String
    ) : Call<WeatherResponse>

}