package com.example.risingcamp.week4_hw

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.R
import com.example.risingcamp.databinding.ActivityTacoFirstBinding


class TacoFirst : AppCompatActivity(){

    private lateinit var binding : ActivityTacoFirstBinding
    private var ck : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTacoFirstBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        //PLAY 버튼 클릭 이벤트
        binding.tacoPlayBtnUnchecked.setOnClickListener {
            val intent = Intent(this, TacoMain::class.java)
            if(ck) {
                binding.tacoPlayBtnUnchecked.setImageResource(R.drawable.taco_play_btn_checked)
            } else {
                binding.tacoTitle.setImageResource(R.drawable.taco_play_btn_unchecked)
            }
            startActivity(intent)
        }
    }
}
