package com.example.risingcamp.week5_hw

import com.example.risingcamp.week5_hw.models.RecommendResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RecommendInterface {
    @GET("api/recommend.api")
    fun getRecommend(@Query("key") key: String,
                     @Query("categoryId") categoryId: Int,
                     @Query("output") output: String
    ) : Call<RecommendResponse>

    @GET("api/search.api")
    fun getSearch(@Query("key") key: String,
                  @Query("query") query: Long,
                  @Query("queryType") queryType: String,
                  @Query("output") output: String
    ) : Call<RecommendResponse>

    @GET("api/bestSeller.api")
    fun getBestseller(@Query("key") key: String,
                      @Query("categoryId") categoryId: Int,
                      @Query("output") output: String
    ) : Call<RecommendResponse>

}