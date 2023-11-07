package com.example.moshi

import com.squareup.moshi.Json

data class Row(
    @field:Json(name = "BIZREGNO")
    val BIZREGNO: String,
    @field:Json(name = "INDUTYPE_NM")
    val INDUTYPE_NM: String,
    @field:Json(name = "REFINE_LOTNO_ADDR")
    val REFINE_LOTNO_ADDR: String,
    @field:Json(name = "REFINE_ROADNM_ADDR")
    val REFINE_ROADNM_ADDR: String,
    @field:Json(name = "REFINE_WGS84_LAT")
    val REFINE_WGS84_LAT: String,
    @field:Json(name = "REFINE_WGS84_LOGT")
    val REFINE_WGS84_LOGT: String,
    @field:Json(name = "REFINE_ZIPNO")
    val REFINE_ZIPNO: String,
    @field:Json(name = "SIGUN_NM")
    val SIGUN_NM: String,
    @field:Json(name = "STR_NM")
    val STR_NM: String
)