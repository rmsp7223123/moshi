package com.example.moshi

import com.squareup.moshi.Json

data class Head(
    @field:Json(name = "RESULT")
    val RESULT: RESULT,
    @field:Json(name = "api_version")
    val api_version: String,
    @field:Json(name = "list_total_count")
    val list_total_count: Int
)