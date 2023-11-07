package com.example.moshi

import com.squareup.moshi.Json

data class GGEXPSDLV(
    @field:Json(name = "head")
    val head: List<Head>,
    @field:Json(name = "row")
    val row: List<Row>
)