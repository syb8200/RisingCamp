package com.example.risingcamp.week3_hw

import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.risingcamp.databinding.ActivityCuEventRouletteBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

// 데이터 클래스(담을 그릇) 만들기
data class RouletteComment(val id:String, val content:String, val date:String)

class CU_event_roulette : AppCompatActivity() {

    // RouletteComment 데이터 형식으로 데이터 추가하기
    var rouletteCommentArrayList = ArrayList<RouletteComment>()

    // 리스트뷰에 어댑터 세팅
    private lateinit var rouletteCommentAdapter: RouletteCommentAdapter

    // 뷰 바인딩
    private lateinit var binding : ActivityCuEventRouletteBinding

    //sp
    private lateinit var sharedPreferences : SharedPreferences

    //현재 날짜 받아오기 -> 현재 날짜 Date 타입으로 변환 -> 날짜 가져오고 싶은 형태로 선언 -> 현재 날짜를 dateFormat에 선언한 형태의 String으로 변환
    val now_date = System.currentTimeMillis()
    val current_date = Date(now_date)
    val current_dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale("ko", "KR"))
    val str_date = current_dateFormat.format(current_date)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCuEventRouletteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Log.d(this.toString(), "onCreate()")

        val rouletteCommentArrayList = arrayListOf(
            //데이터 추가하기
            RouletteComment("010********", "출석체크합니다!", str_date),
            RouletteComment("010********", "출첵!", str_date),
            RouletteComment("010********", "출석해여^^", str_date),
            RouletteComment("010********", "출석!! 건강하세요^^", str_date),
            RouletteComment("010********", "출석합니다.", str_date),
            RouletteComment("010********", "만첵합니다.", str_date),
            RouletteComment("010********", "2월 출석합니다^^", str_date),
            RouletteComment("010********", "출석합니다 화이팅!", str_date),
            RouletteComment("010********", "한달 풀첵 성공!", str_date),
            RouletteComment("010********", "안녕하세요.. 출석합니당", str_date),

            RouletteComment("010********", "출석", str_date),
            RouletteComment("010********", "출석합니다", str_date),
            RouletteComment("010********", "출석 입니다", str_date),
            RouletteComment("010********", "28일 연속 출석 성공", str_date),
            RouletteComment("010********", "출~~~석", str_date),
            RouletteComment("010********", "한달 출석 완료.", str_date),
            RouletteComment("010********", "한달 개근!!", str_date),
            RouletteComment("010********", "한달 완료요", str_date),
            RouletteComment("010********", "출석합니당", str_date),
            RouletteComment("010********", "출석~~~", str_date),
            RouletteComment("010********", "2월 모두 출석이요~", str_date),

            RouletteComment("010********", "출석입니당~", str_date),
            RouletteComment("010********", "출석해써요", str_date),
            RouletteComment("010********", "출첵완료", str_date),
            RouletteComment("010********", "출석했음 포인트주셈", str_date),
            RouletteComment("010********", "2022 화이팅!", str_date),
            RouletteComment("010********", "출석이요오~~", str_date),
            RouletteComment("010********", "매번 출석하고 갑니다~", str_date),
            RouletteComment("010********", "이번 달 만땅 출석!", str_date),
            RouletteComment("010********", "오늘도 출석하고 갑니다", str_date),
            RouletteComment("010********", "매일 출석 고고", str_date)
        )

        binding.cuEventRouletteListview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.cuEventRouletteListview.setHasFixedSize(true)

        binding.cuEventRouletteListview.adapter = RouletteCommentAdapter(rouletteCommentArrayList)

        //아이템 하단 경계선 추가
        binding.cuEventRouletteListview.addItemDecoration(DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL))

        //등록 버튼 -> recyclerview에 item 추가
        binding.cuEventRouletteSaveBtn.setOnClickListener{

            val builder = AlertDialog.Builder(this)
            builder.setTitle("")
                .setMessage("등록하시겠습니까?")
                .setNegativeButton("취소", DialogInterface.OnClickListener{dialog, which -> null})
                .setPositiveButton("확인", DialogInterface.OnClickListener{dialog, which ->

                    rouletteCommentArrayList.add(RouletteComment("010********", binding.cuEventRouletteEdt.text.toString(), str_date))

                    binding.cuEventRouletteListview.adapter = RouletteCommentAdapter(rouletteCommentArrayList)

                    val comment_count = binding.cuEventRouletteCommentCount.text.toString()
                    val add_comment_count : Int = comment_count.toInt() +1
                    binding.cuEventRouletteCommentCount.text = add_comment_count.toString()
                    Log.d(this.toString(),"아이템 추가 완료")

                    binding.cuEventRouletteEdt.text.clear()
                })
            builder.show()
        }

    }
}