package com.example.risingcamp.week3_hw

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.risingcamp.R

class RouletteCommentAdapter(private val rouletteCommentArrayList:ArrayList<RouletteComment>): RecyclerView.Adapter<RouletteCommentAdapter.CustomViewHolder>() {

    //시스템에 있는 API 호출해서 애플리케이션에서 쓸 수 있는, 쉽게 말해서 앱과 OS 사이에 중재자 역할을 한다고 보면 된다.
    //private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    //lateinit var binding: ItemCuEventRouletteBinding

    //뷰 홀더가 처음 생성될 때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cu_event_roulette, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener{
                val curPos : Int = adapterPosition
                val builder = AlertDialog.Builder(parent.context)
                builder.setTitle("")
                    .setMessage("삭제하시겠습니까?")
                    .setNegativeButton("취소", DialogInterface.OnClickListener{dialog, which -> null})
                    .setPositiveButton("확인", DialogInterface.OnClickListener{dialog, which ->

                        rouletteCommentArrayList.removeAt(curPos)
                        notifyDataSetChanged()
                    })
                builder.show()
                //val comment : RouletteComment = rouletteCommentArrayList.get(curPos)
                //Toast.makeText(parent.context, "내용: ${comment.content}", Toast.LENGTH_SHORT).show()

            }

        }
    }

    //ArrayList의 사이즈를 반환해준다.
    override fun getItemCount(): Int = rouletteCommentArrayList.size

    //재활용해주는 곳 및 값을 넣어주는 곳
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.item_id.text = rouletteCommentArrayList.get(position).id
        holder.item_content.text = rouletteCommentArrayList.get(position).content
        holder.item_date.text = rouletteCommentArrayList.get(position).date
    }

    class CustomViewHolder (v: View) : RecyclerView.ViewHolder(v){
        private var view: View = v

        val item_id = v.findViewById<TextView>(R.id.item_roulette_id) //아이디(폰번호)
        val item_content = v.findViewById<TextView>(R.id.item_roulette_content) //내용
        val item_date = v.findViewById<TextView>(R.id.item_roulette_date) //날

    }



/*
    //위치 값에 따른 데이터
    override fun getItem(p0: Int): Any = rouletteCommentArrayList[p0]

    //position 값을 반환해준다. (=을 사용해줬는데, 코틀린에서는 타입 추론이 가증해서 =만 작성해도 return type을 자동으로 추론해준다.)
    override fun getItemId(p0: Int): Long = p0.toLong()

    //화면 크기만큼 item_layout(여기서는 item_listview_practice3)이 들어갈 수 있는 공간을 채울 때 만큼 호출이 되고,
    // 그 다음에는 스크롤이 되서 아이템이 보일 때마다 호출이 되는 함
    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        binding = ItemCuEventRouletteBinding.inflate(inflater,p2,false)
        binding.itemRouletteId.text = rouletteCommentArrayList[position].id
        binding.itemRouletteContent.text = rouletteCommentArrayList[position].content
        binding.itemRouletteDate.text = rouletteCommentArrayList[position].date

        return binding.root
    }
 */

}