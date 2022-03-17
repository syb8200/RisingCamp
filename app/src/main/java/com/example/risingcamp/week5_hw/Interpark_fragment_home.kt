package com.example.risingcamp.week5_hw

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.risingcamp.R
import com.example.risingcamp.week3_hw.RouletteCommentAdapter
import com.example.risingcamp.week4_hw.TacoMain
import com.example.risingcamp.week5_hw.models.RecommendResponse
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interpark_fragment_home : Fragment() {

    val API_KEY : String = "B91AE6F8D1E9702FB8D9CD1FC356A6E0F422AA40510994A9DC06E2196E716175"
    val categoryId : Int = 100
    val output : String = "json"
    val queryType : String = "isbn"

    var interpark_home_card_1 : LinearLayout? = null

    var hscroll_1_img : ImageView? = null
    var hscroll_2_img : ImageView? = null
    var hscroll_3_img : ImageView? = null
    var hscroll_4_img : ImageView? = null
    var hscroll_5_img : ImageView? = null
    var hscroll_6_img : ImageView? = null
    var hscroll_7_img : ImageView? = null
    var hscroll_8_img : ImageView? = null

    var hscroll_1_title : TextView? = null
    var hscroll_2_title : TextView? = null
    var hscroll_3_title : TextView? = null
    var hscroll_4_title : TextView? = null
    var hscroll_5_title : TextView? = null
    var hscroll_6_title : TextView? = null
    var hscroll_7_title : TextView? = null
    var hscroll_8_title : TextView? = null

    var title_1 : String? = null
    var title_2 : String? = null
    var title_3 : String? = null
    var title_4 : String? = null
    var title_5 : String? = null
    var title_6 : String? = null
    var title_7 : String? = null
    var title_8 : String? = null

    var cover_img_1 : String? = null
    var cover_img_2 : String? = null
    var cover_img_3 : String? = null
    var cover_img_4 : String? = null
    var cover_img_5 : String? = null
    var cover_img_6 : String? = null
    var cover_img_7 : String? = null
    var cover_img_8 : String? = null

    var interpark_home_card_img_1 : ImageView? = null
    var interpark_home_card_img_2 : ImageView? = null
    var interpark_home_card_img_3 : ImageView? = null
    var interpark_home_card_img_4 : ImageView? = null
    var interpark_home_card_img_5 : ImageView? = null

    var card_cover_img_1 : String? = null
    var card_cover_img_2 : String? = null
    var card_cover_img_3 : String? = null
    var card_cover_img_4 : String? = null
    var card_cover_img_5 : String? = null

    var interpark_home_card_title_1 : TextView? = null
    var interpark_home_card_title_2 : TextView? = null
    var interpark_home_card_title_3 : TextView? = null
    var interpark_home_card_title_4 : TextView? = null
    var interpark_home_card_title_5 : TextView? = null

    var interpark_home_card_content_1 : TextView? = null
    var interpark_home_card_content_2 : TextView? = null
    var interpark_home_card_content_3 : TextView? = null
    var interpark_home_card_content_4 : TextView? = null
    var interpark_home_card_content_5 : TextView? = null

    val fragment1 = Interpark_fragment_table_1()
    val fragment2 = Interpark_fragment_table_2()
    val fragment3 = Interpark_fragment_table_3()
    val fragment4 = Interpark_fragment_table_4()
    val fragment5 = Interpark_fragment_table_5()
    val fragment6 = Interpark_fragment_table_6()

    val handler = Handler(Looper.getMainLooper()){
        setPage()
        true
    }

    var currentPosition = 0

    var viewPager : ViewPager2? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_interpark_home, container, false)

        //인터파크 추천
        interpark_home_card_1 = view.findViewById(R.id.interpark_home_card_1)
        interpark_home_card_1?.setOnClickListener{
            activity?.let {
                val intent = Intent(context, Interpark_book::class.java)
                startActivity(intent)
            }
        }

        interpark_home_card_img_1 = view.findViewById(R.id.interpark_home_card_img_1)
        interpark_home_card_img_2 = view.findViewById(R.id.interpark_home_card_img_2)
        interpark_home_card_img_3 = view.findViewById(R.id.interpark_home_card_img_3)
        interpark_home_card_img_4 = view.findViewById(R.id.interpark_home_card_img_4)
        interpark_home_card_img_5 = view.findViewById(R.id.interpark_home_card_img_5)

        interpark_home_card_title_1 = view.findViewById(R.id.interpark_home_card_title_1)
        interpark_home_card_title_2 = view.findViewById(R.id.interpark_home_card_title_2)
        interpark_home_card_title_3 = view.findViewById(R.id.interpark_home_card_title_3)
        interpark_home_card_title_4 = view.findViewById(R.id.interpark_home_card_title_4)
        interpark_home_card_title_5 = view.findViewById(R.id.interpark_home_card_title_5)

        interpark_home_card_content_1 = view.findViewById(R.id.interpark_home_card_content_1)
        interpark_home_card_content_2 = view.findViewById(R.id.interpark_home_card_content_2)
        interpark_home_card_content_3 = view.findViewById(R.id.interpark_home_card_content_3)
        interpark_home_card_content_4 = view.findViewById(R.id.interpark_home_card_content_4)
        interpark_home_card_content_5 = view.findViewById(R.id.interpark_home_card_content_5)

        //회원님을 위한 추천
        hscroll_1_img = view.findViewById(R.id.interpark_home_recommend_hscroll_1_img)
        hscroll_2_img = view.findViewById(R.id.interpark_home_recommend_hscroll_2_img)
        hscroll_3_img = view.findViewById(R.id.interpark_home_recommend_hscroll_3_img)
        hscroll_4_img = view.findViewById(R.id.interpark_home_recommend_hscroll_4_img)
        hscroll_5_img = view.findViewById(R.id.interpark_home_recommend_hscroll_5_img)
        hscroll_6_img = view.findViewById(R.id.interpark_home_recommend_hscroll_6_img)
        hscroll_7_img = view.findViewById(R.id.interpark_home_recommend_hscroll_7_img)
        hscroll_8_img = view.findViewById(R.id.interpark_home_recommend_hscroll_8_img)

        hscroll_1_title = view.findViewById(R.id.interpark_home_recommend_hscroll_1_title)
        hscroll_2_title = view.findViewById(R.id.interpark_home_recommend_hscroll_2_title)
        hscroll_3_title = view.findViewById(R.id.interpark_home_recommend_hscroll_3_title)
        hscroll_4_title = view.findViewById(R.id.interpark_home_recommend_hscroll_4_title)
        hscroll_5_title = view.findViewById(R.id.interpark_home_recommend_hscroll_5_title)
        hscroll_6_title = view.findViewById(R.id.interpark_home_recommend_hscroll_6_title)
        hscroll_7_title = view.findViewById(R.id.interpark_home_recommend_hscroll_7_title)
        hscroll_8_title = view.findViewById(R.id.interpark_home_recommend_hscroll_8_title)

        //인터파크 추천 스크롤
        getBestsellerData(key = API_KEY, categoryId = categoryId ,output = output)

        //회원님을 위한 추천 스크롤
        getSearchData(key = API_KEY, query = 9791191043655, queryType = queryType, output = output)
        getSearchData(key = API_KEY, query = 9791187142560, queryType = queryType, output = output)
        getSearchData(key = API_KEY, query = 9788991759732, queryType = queryType, output = output)
        getSearchData(key = API_KEY, query = 9791130679822, queryType = queryType, output = output)
        getSearchData(key = API_KEY, query = 9791191891072, queryType = queryType, output = output)
        getSearchData(key = API_KEY, query = 9791165344221, queryType = queryType, output = output)
        getSearchData(key = API_KEY, query = 9791155811856, queryType = queryType, output = output)
        getSearchData(key = API_KEY, query = 9788935213573, queryType = queryType, output = output)


        var table_1 = view.findViewById<TextView>(R.id.interpark_home_table_1)
        var table_2 = view.findViewById<TextView>(R.id.interpark_home_table_2)
        var table_3 = view.findViewById<TextView>(R.id.interpark_home_table_3)
        var table_4 = view.findViewById<TextView>(R.id.interpark_home_table_4)
        var table_5 = view.findViewById<TextView>(R.id.interpark_home_table_5)
        var table_6 = view.findViewById<TextView>(R.id.interpark_home_table_6)


        //상단 배너 - 뷰페이저2 적용
        viewPager = view.findViewById(R.id.interpark_top_banner)
        val viewpagerFragmentAdapter = ViewpagerFragmentAdapter(requireActivity())
        viewPager!!.adapter = viewpagerFragmentAdapter

        currentPosition=0
        viewPager!!.setCurrentItem(0,true)

        val thread = Thread(PagerRunnable())
        thread.start()


        //테이블 관련
        table_1.setTextColor(Color.parseColor("#DB951C"))
        childFragmentManager.beginTransaction().replace(R.id.interpark_home_recommend_part_framelayout, fragment1).commit()

        table_1.setOnClickListener{
            ShowTab1()
            table_1.setTextColor(Color.parseColor("#DB951C"))
            table_2.setTextColor(Color.parseColor("#000000"))
            table_3.setTextColor(Color.parseColor("#000000"))
            table_4.setTextColor(Color.parseColor("#000000"))
            table_5.setTextColor(Color.parseColor("#000000"))
            table_6.setTextColor(Color.parseColor("#000000"))
        }
        table_2.setOnClickListener{
            ShowTab2()
            table_1.setTextColor(Color.parseColor("#000000"))
            table_2.setTextColor(Color.parseColor("#DB951C"))
            table_3.setTextColor(Color.parseColor("#000000"))
            table_4.setTextColor(Color.parseColor("#000000"))
            table_5.setTextColor(Color.parseColor("#000000"))
            table_6.setTextColor(Color.parseColor("#000000"))
        }
        table_3.setOnClickListener{
            ShowTab3()
            table_1.setTextColor(Color.parseColor("#000000"))
            table_2.setTextColor(Color.parseColor("#000000"))
            table_3.setTextColor(Color.parseColor("#DB951C"))
            table_4.setTextColor(Color.parseColor("#000000"))
            table_5.setTextColor(Color.parseColor("#000000"))
            table_6.setTextColor(Color.parseColor("#000000"))
        }
        table_4.setOnClickListener{
            ShowTab4()
            table_1.setTextColor(Color.parseColor("#000000"))
            table_2.setTextColor(Color.parseColor("#000000"))
            table_3.setTextColor(Color.parseColor("#000000"))
            table_4.setTextColor(Color.parseColor("#DB951C"))
            table_5.setTextColor(Color.parseColor("#000000"))
            table_6.setTextColor(Color.parseColor("#000000"))
        }
        table_5.setOnClickListener{
            ShowTab5()
            table_1.setTextColor(Color.parseColor("#000000"))
            table_2.setTextColor(Color.parseColor("#000000"))
            table_3.setTextColor(Color.parseColor("#000000"))
            table_4.setTextColor(Color.parseColor("#000000"))
            table_5.setTextColor(Color.parseColor("#DB951C"))
            table_6.setTextColor(Color.parseColor("#000000"))
        }
        table_6.setOnClickListener{
            ShowTab6()
            table_1.setTextColor(Color.parseColor("#000000"))
            table_2.setTextColor(Color.parseColor("#000000"))
            table_3.setTextColor(Color.parseColor("#000000"))
            table_4.setTextColor(Color.parseColor("#000000"))
            table_5.setTextColor(Color.parseColor("#000000"))
            table_6.setTextColor(Color.parseColor("#DB951C"))
        }

        return view
    }


    fun ShowTab1(){
        val transaction = childFragmentManager.beginTransaction()
        childFragmentManager.beginTransaction()
        transaction.replace(R.id.interpark_home_recommend_part_framelayout, fragment1)
        transaction.addToBackStack(null)
        transaction.commit()

    }
    fun ShowTab2(){
        val transaction = childFragmentManager.beginTransaction()
        childFragmentManager.beginTransaction()
        transaction.replace(R.id.interpark_home_recommend_part_framelayout, fragment2)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun ShowTab3(){
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.interpark_home_recommend_part_framelayout, fragment3)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun ShowTab4(){
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.interpark_home_recommend_part_framelayout, fragment4)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun ShowTab5(){
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.interpark_home_recommend_part_framelayout, fragment5)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun ShowTab6(){
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.interpark_home_recommend_part_framelayout, fragment6)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun setPage(){
        if(currentPosition==5) currentPosition=0
        viewPager!!.setCurrentItem(currentPosition, true)
        currentPosition+=1
    }

    inner class PagerRunnable:Runnable{
        override fun run() {
            while (true){
                Thread.sleep(3000)
                handler.sendEmptyMessage(0)
            }
        }
    }

    //첫 번째 스크롤
    private fun getBestsellerData(key: String, categoryId: Int, output: String) {
        val recommendInterface = RetrofitClient.sRetrofit.create(RecommendInterface::class.java)
        recommendInterface.getBestseller(key, categoryId, output).enqueue(object :
            Callback<RecommendResponse> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<RecommendResponse>,
                response: Response<RecommendResponse>
            ) {
                if(response.isSuccessful){
                    val result = response.body() as RecommendResponse

                    //Textview, Imageview에 값 받아오기
                    interpark_home_card_title_1?.text = result.item[0].title.toString()
                    interpark_home_card_title_2?.text = result.item[1].title.toString()
                    interpark_home_card_title_3?.text = result.item[2].title.toString()
                    interpark_home_card_title_4?.text = result.item[3].title.toString()
                    interpark_home_card_title_5?.text = result.item[4].title.toString()

                    interpark_home_card_content_1?.text = result.item[0].description.toString()
                    interpark_home_card_content_2?.text = result.item[1].description.toString()
                    interpark_home_card_content_3?.text = result.item[2].description.toString()
                    interpark_home_card_content_4?.text = result.item[3].description.toString()
                    interpark_home_card_content_5?.text = result.item[4].description.toString()

                    //ImageUrl 받아오기
                    card_cover_img_1 = result.item[0].coverLargeUrl.toString()
                    card_cover_img_2 = result.item[1].coverLargeUrl.toString()
                    card_cover_img_3 = result.item[2].coverLargeUrl.toString()
                    card_cover_img_4 = result.item[3].coverLargeUrl.toString()
                    card_cover_img_5 = result.item[4].coverLargeUrl.toString()

                    getImageURL_9(card_cover_img_1!!)
                    getImageURL_10(card_cover_img_2!!)
                    getImageURL_11(card_cover_img_3!!)
                    getImageURL_12(card_cover_img_4!!)
                    getImageURL_13(card_cover_img_5!!)

                } else{
                    Log.d("cardscroll", "getBestsellerData - onResponse : Error code ${response.code()}")
                }
            }

            override fun onFailure(call: Call<RecommendResponse>, t: Throwable) {
                Log.d("cardscroll", t.message ?: "통신오류")
            }

        })
    }

    //두 번째 스크롤
    private fun getSearchData(key: String, query: Long, queryType: String, output: String) {
        val recommendInterface = RetrofitClient.sRetrofit.create(RecommendInterface::class.java)
        recommendInterface.getSearch(key, query, queryType, output).enqueue(object :
            Callback<RecommendResponse> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<RecommendResponse>,
                response: Response<RecommendResponse>
            ) {
                if(response.isSuccessful){
                    val result = response.body() as RecommendResponse

                    //Textview, Imageview에 값 받아오기
                    if(query==9791191043655){
                        title_1 = result.item[0].title.toString()
                        hscroll_1_title?.text = title_1
                        cover_img_1 = result.item[0].coverLargeUrl.toString()
                        getImageURL_1(cover_img_1!!)

                    } else if(query==9791187142560){
                        title_2 = result.item[0].title.toString()
                        hscroll_2_title?.text = title_2
                        cover_img_2 = result.item[0].coverLargeUrl.toString()
                        getImageURL_2(cover_img_2!!)

                    } else if(query==9788991759732){
                        title_3 = result.item[0].title.toString()
                        hscroll_3_title?.text = title_3
                        cover_img_3 = result.item[0].coverLargeUrl.toString()
                        getImageURL_3(cover_img_3!!)

                    } else if(query==9791130679822){
                        title_4 = result.item[0].title.toString()
                        hscroll_4_title?.text = title_4
                        cover_img_4 = result.item[0].coverLargeUrl.toString()
                        getImageURL_4(cover_img_4!!)

                    } else if(query==9791191891072){
                        title_5 = result.item[0].title.toString()
                        hscroll_5_title?.text = title_5
                        cover_img_5 = result.item[0].coverLargeUrl.toString()
                        getImageURL_5(cover_img_5!!)

                    } else if(query==9791165344221){
                        title_6 = result.item[0].title.toString()
                        hscroll_6_title?.text = title_6
                        cover_img_6 = result.item[0].coverLargeUrl.toString()
                        getImageURL_6(cover_img_6!!)

                    } else if(query==9791155811856){
                        title_7 = result.item[0].title.toString()
                        hscroll_7_title?.text = title_7
                        cover_img_7 = result.item[0].coverLargeUrl.toString()
                        getImageURL_7(cover_img_7!!)

                    } else if(query==9788935213573){
                        title_8 = result.item[0].title.toString()
                        hscroll_8_title?.text = title_8
                        cover_img_8 = result.item[0].coverLargeUrl.toString()
                        getImageURL_8(cover_img_8!!)
                    }

                } else{
                    Log.d("hscroll", "getSearchData - onResponse : Error code ${response.code()}")
                }
            }

            override fun onFailure(call: Call<RecommendResponse>, t: Throwable) {
                Log.d("hscroll", t.message ?: "통신오류")
            }

        })
    }

    fun getImageURL_1(imageURL: String){
        Glide.with(requireContext())
            .load(imageURL)
            .into(hscroll_1_img!!)
    }

    fun getImageURL_2(imageURL: String){
        Glide.with(requireContext())
            .load(imageURL)
            .into(hscroll_2_img!!)
    }

    fun getImageURL_3(imageURL: String){
        Glide.with(requireContext())
            .load(imageURL)
            .into(hscroll_3_img!!)
    }

    fun getImageURL_4(imageURL: String){
        Glide.with(requireContext())
            .load(imageURL)
            .into(hscroll_4_img!!)
    }
    fun getImageURL_5(imageURL: String){
        Glide.with(requireContext())
            .load(imageURL)
            .into(hscroll_5_img!!)
    }
    fun getImageURL_6(imageURL: String){
        Glide.with(requireContext())
            .load(imageURL)
            .into(hscroll_6_img!!)
    }
    fun getImageURL_7(imageURL: String){
        Glide.with(requireContext())
            .load(imageURL)
            .into(hscroll_7_img!!)
    }
    fun getImageURL_8(imageURL: String){
        Glide.with(requireContext())
            .load(imageURL)
            .into(hscroll_8_img!!)
    }


    fun getImageURL_9(imageURL: String){
        Glide.with(requireContext())
            .load(imageURL)
            .into(interpark_home_card_img_1!!)
    }
    fun getImageURL_10(imageURL: String){
        Glide.with(requireContext())
            .load(imageURL)
            .into(interpark_home_card_img_2!!)
    }
    fun getImageURL_11(imageURL: String){
        Glide.with(requireContext())
            .load(imageURL)
            .into(interpark_home_card_img_3!!)
    }
    fun getImageURL_12(imageURL: String){
        Glide.with(requireContext())
            .load(imageURL)
            .into(interpark_home_card_img_4!!)
    }
    fun getImageURL_13(imageURL: String){
        Glide.with(requireContext())
            .load(imageURL)
            .into(interpark_home_card_img_5!!)
    }


}

