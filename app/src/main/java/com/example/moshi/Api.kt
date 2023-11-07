package com.example.moshi

import com.squareup.moshi.Json

data class Api(
    @field:Json(name = "GGEXPSDLV")
    val GGEXPSDLV: List<GGEXPSDLV>
)