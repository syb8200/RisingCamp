package com.example.risingcamp.week5_pt

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.databinding.ActivityMainPractice5Binding
import com.example.risingcamp.week5_pt.models.WeatherResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainPractice5Binding
    var API_KEY = "945360a172b676a1193b147fb6be1870"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainPractice5Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.activityMainBtn.setOnClickListener{
            val cityName = binding.activityMainTv.text.toString()
            getWeatherData(cityName, API_KEY)
        }

    }

    //MainActivity에 API 호출을 위한 getWeatherData 메서드를 구성
    private fun getWeatherData(city: String, key: String){
        val weatherInterface = RetrofitClient.sRetrofit.create(WeatherInterface::class.java)
        //enqueue() 메서드를 통해 비동기적으로 네트워크 통신 진행
        weatherInterface.getWeather(city, key).enqueue(object : retrofit2.Callback<WeatherResponse>{
            //Response를 정상적으로 잘 받았을 때, 실패했을 때의 경우를 나누어 예외처리
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if(response.isSuccessful){
                    val result = response.body() as WeatherResponse
                    binding.activityMainTv.text = result.main.temp.toString() + "도"
                } else{
                    Log.d("MainActivity", "getWeatherData - onResponse : Error code ${response.code()}")
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.d("MainActivity", t.message ?: "통신오류")
            }

        })
    }
}
