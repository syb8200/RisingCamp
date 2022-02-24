package com.example.risingcamp.third_week_practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.databinding.ActivityMainPractice3Binding

//이름과 내용을 담을 그릇 만들기
data class BusinessCard(val name:String, val contents:String)

class MainActivity : AppCompatActivity() {

    //비즈니스 카드 데이터 형식으로 데이터 추가하기
    var businessCardArrayList = ArrayList<BusinessCard>()

    //어댑터를 리스트뷰에 세팅하기 (여기서 lateinit을 한 이유는 arraylist를 만들었는데 그거를 추후에 arraylist에 대한 데이터를 좀 추가를
    //한 다음에 초기화 세팅을 하기 위해서)
    private lateinit var customAdapter: CustomAdapter

    //뷰 바인딩
    private lateinit var binding : ActivityMainPractice3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainPractice3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //데이터 추가하기
        for(x in 0..30){

            businessCardArrayList.add(BusinessCard("록", "하이"))
            businessCardArrayList.add(BusinessCard("담", "하이"))
            businessCardArrayList.add(BusinessCard("록", "하이"))
            businessCardArrayList.add(BusinessCard("담", "하이"))

        }

        //어댑터 세팅
        customAdapter = CustomAdapter(this, businessCardArrayList)

        //리스트뷰에 어댑터 집어넣기
        binding.listviewMain.adapter = customAdapter


    }
}