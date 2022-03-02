package com.example.risingcamp.week3_hw

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.R
import com.example.risingcamp.databinding.ActivityCuMembershipCardBinding

//카드 이미지와 카드 이름을 담을 그릇 만들기
data class MembershipCard(val img: Int, val name:String, var isSwitched:Boolean=false)

class CU_membership_card : AppCompatActivity() {

    //멤버십 카드 데이터 형식으로 데이터 추가하기
    var membershipCardArrayList = ArrayList<MembershipCard>()

    //어댑터를 리스트뷰에 세팅하기
    private lateinit var membershipCardAdapter: MembershipCardAdapter

    // 뷰 바인딩
    private lateinit var binding : ActivityCuMembershipCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCuMembershipCardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Log.d(this.toString(), "onCreate()")

        val membershipCardArrayList = arrayListOf(
            MembershipCard(R.drawable.cu_membership_card_1, "CU 멤버십(기본 카드)", false),
            MembershipCard(R.drawable.cu_membership_card_2, "CU 플러스 티머니카드", false),
            MembershipCard(R.drawable.cu_membership_card_3, "CU 캐시비 교통카드", false),
            MembershipCard(R.drawable.cu_membership_card_4, "CU 레일플러스 카드", false),
            MembershipCard(R.drawable.cu_membership_card_5, "하나CU 스페셜 미생카드", false),
            MembershipCard(R.drawable.cu_membership_card_6, "신한CU 모닝 체크카드", false),
            MembershipCard(R.drawable.cu_membership_card_1, "CU 멤버십(기본 카드)", false),
            MembershipCard(R.drawable.cu_membership_card_2, "CU 플러스 티머니카드", false)
        )

        //어댑터 세팅
        membershipCardAdapter = MembershipCardAdapter(this, membershipCardArrayList)

        //리스트뷰에 어댑터 집어넣기
        binding.cuMembershipCardListview.adapter = membershipCardAdapter
        

    }
}