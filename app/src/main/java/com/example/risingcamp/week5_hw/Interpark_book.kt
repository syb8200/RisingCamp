package com.example.risingcamp.week5_hw

import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.risingcamp.R
import com.example.risingcamp.databinding.ActivityCuSelfauthBinding
import com.example.risingcamp.databinding.ActivityInterparkBookBinding
import com.example.risingcamp.week5_hw.models.RecommendResponse
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interpark_book : AppCompatActivity() {

    private lateinit var binding : ActivityInterparkBookBinding

    val API_KEY : String = "B91AE6F8D1E9702FB8D9CD1FC356A6E0F422AA40510994A9DC06E2196E716175"
    val categoryId : Int = 100
    val output : String = "json"

    var cover_Img : String? = null
    var title : String? = null
    var author : String? = null
    var publisher : String? = null
    var pubdate : String? = null
    var week_rank : String? = null
    var state : String? = null
    var count_review : String? = null
    var rate : String? = null
    var discount_price : String? = null
    var not_discount_price : String? = null
    var discount_rate : String? = null
    var mileage : String? = null
    var description : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInterparkBookBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //인터파크 추천 스크롤
        getBestsellerData(key = API_KEY, categoryId = categoryId ,output = output)

        binding.interparkBookNotDiscountPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG)


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

                    cover_Img = result.item[0].coverLargeUrl.toString()
                    title = result.item[0].title.toString()
                    author = result.item[0].author.toString()
                    publisher = result.item[0].publisher.toString()
                    pubdate = result.item[0].pubDate.toString()
                    week_rank = result.item[0].rank.toString()
                    state = result.item[0].saleStatus.toString()
                    count_review = result.item[0].reviewCount.toString()
                    rate = result.item[0].customerReviewRank.toString()
                    discount_price = result.item[0].priceSales.toString()
                    not_discount_price = result.item[0].priceStandard.toString()
                    discount_rate = result.item[0].discountRate.toString()
                    mileage = result.item[0].mileage.toString()
                    description = result.item[0].description.toString()

                    binding.interparkBookTitle.text = title.toString()
                    binding.interparkBookAuthor.text = author.toString()
                    binding.interparkBookPublish.text = publisher.toString()
                    binding.interparkBookDate.text = pubdate.toString()
                    binding.interparkBookWeekRank.text = week_rank.toString()
                    binding.interparkBookState.text = state.toString()
                    binding.interparkBookCountReview.text = count_review.toString()
                    binding.interparkBookRate.text = rate.toString()
                    binding.interparkBookDiscountPrice.text = discount_price.toString()
                    binding.interparkBookNotDiscountPrice.text = not_discount_price.toString()
                    binding.interparkBookDiscountRate.text = discount_rate.toString()
                    binding.interparkBookMileage.text = mileage.toString()
                    binding.interparkBookIntroDetail.text = description.toString()

                    getImageURL(cover_Img!!)
                    Log.d("사진","가져와졌는지? ${cover_Img}")

                } else{
                    Log.d("book", "getBestsellerData - onResponse : Error code ${response.code()}")
                }
            }

            override fun onFailure(call: Call<RecommendResponse>, t: Throwable) {
                Log.d("book", t.message ?: "통신오류")
            }

        })
    }

    fun getImageURL(imageURL: String){
        Glide.with(applicationContext)
            .load(imageURL)
            .into(binding.interparkBookCoverImg)
    }
}