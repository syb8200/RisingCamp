package com.example.risingcamp.week3_hw

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.risingcamp.R

class MembershipCardAdapter(val context: Context, private val membershipCardArrayList:ArrayList<MembershipCard>): BaseAdapter(){

    //ArrayList의 사이즈를 반환해준다.
    override fun getCount(): Int = membershipCardArrayList.size

    //위치 값에 따른 데이터
    override fun getItem(p0: Int): Any = membershipCardArrayList[p0]

    //position 값을 반환해준다. (=을 사용해줬는데, 코틀린에서는 타입 추론이 가증해서 =만 작성해도 return type을 자동으로 추론해준다.)
    override fun getItemId(p0: Int): Long = p0.toLong()

    //화면 크기만큼 item_layout(여기서는 item_listview_practice3)이 들어갈 수 있는 공간을 채울 때 만큼 호출이 되고,
    // 그 다음에는 스크롤이 되서 아이템이 보일 때마다 호출이 되는 함
    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        //시스템에 있는 API 호출해서 애플리케이션에서 쓸 수 있는, 쉽게 말해서 앱과 OS 사이에 중재자 역할을 한다고 보면 된다.
        val view : View = LayoutInflater.from(context).inflate(R.layout.item_cu_membership_card, null)

        val img = view.findViewById<ImageView>(R.id.cu_membership_card_img)
        val cardname = view.findViewById<TextView>(R.id.cu_membership_card_name_txt)
        val favorite = view.findViewById<Switch>(R.id.cu_membership_card_favorite)

        val membershipcard = membershipCardArrayList[position]

        img.setImageResource(membershipcard.img)
        cardname.text = membershipcard.name
        favorite.isChecked = membershipcard.isSwitched

        favorite.setOnCheckedChangeListener{compoundButton:CompoundButton, b:Boolean ->

            if(b==true){
                Toast.makeText(context, "즐겨찾기에 추가되었습니다.", Toast.LENGTH_SHORT).show()
                membershipCardArrayList[position].isSwitched = true
            } else {
                Toast.makeText(context, "즐겨찾기에서 해제되었습니다.", Toast.LENGTH_SHORT).show()
                membershipCardArrayList[position].isSwitched = false
            }

        }

        return view


    }
}