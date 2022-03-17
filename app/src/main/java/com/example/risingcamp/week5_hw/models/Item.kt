package com.example.risingcamp.week5_hw.models

data class Item(
    val additionalLink: String,
    val author: String,
    val categoryId: String,
    val categoryName: String,
    val coverLargeUrl: String,
    val coverSmallUrl: String,
    val customerReviewRank: Float,
    val description: String,
    val discountRate: String,
    val isbn: String,
    val itemId: Int,
    val link: String,
    val mileage: String,
    val mileageRate: String,
    val mobileLink: String,
    val priceSales: Int,
    val priceStandard: Int,
    val pubDate: String,
    val publisher: String,
    val reviewCount: Int,
    val saleStatus: String,
    val title: String,
    val translator: String,
    val rank: String
)