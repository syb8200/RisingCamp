package com.example.risingcamp.week5_hw

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.risingcamp.R
import com.example.risingcamp.week5_hw.models.RecommendResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interpark_fragment_table_3 : Fragment() {

    val categoryId : Int = 117
    val API_KEY : String = "B91AE6F8D1E9702FB8D9CD1FC356A6E0F422AA40510994A9DC06E2196E716175"
    val output : String = "json"

    var interpark_table_title_1 : TextView? = null
    var interpark_table_title_2 : TextView? = null
    var interpark_table_title_3 : TextView? = null
    var interpark_table_title_4 : TextView? = null

    var interpark_table_img_1 : ImageView? = null
    var interpark_table_img_2 : ImageView? = null
    var interpark_table_img_3 : ImageView? = null
    var interpark_table_img_4 : ImageView? = null

    var title_1 : String? = null
    var title_2 : String? = null
    var title_3 : String? = null
    var title_4 : String? = null

    var cover_img_1 : String? = null
    var cover_img_2 : String? = null
    var cover_img_3 : String? = null
    var cover_img_4 : String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_interpark_table_element, container, false)

        interpark_table_title_1 = view.findViewById(R.id.interpark_table_title_1)
        interpark_table_title_2 = view.findViewById(R.id.interpark_table_title_2)
        interpark_table_title_3 = view.findViewById(R.id.interpark_table_title_3)
        interpark_table_title_4 = view.findViewById(R.id.interpark_table_title_4)

        interpark_table_img_1 = view.findViewById(R.id.interpark_table_img_1)
        interpark_table_img_2 = view.findViewById(R.id.interpark_table_img_2)
        interpark_table_img_3 = view.findViewById(R.id.interpark_table_img_3)
        interpark_table_img_4 = view.findViewById(R.id.interpark_table_img_4)

        getRecommendData(key = API_KEY, categoryId = categoryId, output = output)

        return view
    }

    private fun getRecommendData(key: String, categoryId: Int, output: String) {
        val recommendInterface = RetrofitClient.sRetrofit.create(RecommendInterface::class.java)
        recommendInterface.getRecommend(key, categoryId, output).enqueue(object :
            Callback<RecommendResponse> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<RecommendResponse>,
                response: Response<RecommendResponse>
            ) {
                if(response.isSuccessful){
                    val result = response.body() as RecommendResponse

                    //Textview에 책 제목 값 받아오기
                    title_1 = result.item[0].title.toString()
                    title_2 = result.item[1].title.toString()
                    title_3 = result.item[2].title.toString()
                    title_4 = result.item[3].title.toString()

                    interpark_table_title_1?.text = title_1
                    interpark_table_title_2?.text = title_2
                    interpark_table_title_3?.text = title_3
                    interpark_table_title_4?.text = title_4

                    //ImageUrl 받아오기
                    cover_img_1 = result.item[0].coverLargeUrl.toString()
                    cover_img_2 = result.item[1].coverLargeUrl.toString()
                    cover_img_3 = result.item[2].coverLargeUrl.toString()
                    cover_img_4 = result.item[3].coverLargeUrl.toString()

                    getImageURL_1(cover_img_1!!)
                    getImageURL_2(cover_img_2!!)
                    getImageURL_3(cover_img_3!!)
                    getImageURL_4(cover_img_4!!)

                } else{
                    Log.d("table_3", "getRecommendData - onResponse : Error code ${response.code()}")
                }
            }

            override fun onFailure(call: Call<RecommendResponse>, t: Throwable) {
                Log.d("table_3", t.message ?: "통신오류")
            }

        })
    }

    fun getImageURL_1(imageURL: String){
        Glide.with(requireContext())
            .load(imageURL)
            .into(interpark_table_img_1!!)
    }

    fun getImageURL_2(imageURL: String){
        Glide.with(requireContext())
            .load(imageURL)
            .into(interpark_table_img_2!!)
    }

    fun getImageURL_3(imageURL: String){
        Glide.with(requireContext())
            .load(imageURL)
            .into(interpark_table_img_3!!)
    }

    fun getImageURL_4(imageURL: String){
        Glide.with(requireContext())
            .load(imageURL)
            .into(interpark_table_img_4!!)
    }
}