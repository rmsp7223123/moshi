package com.example.moshi

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Api(
    @field:Json(name = "GGEXPSDLV")
    val GGEXPSDLV: List<GGEXPSDLV>
)