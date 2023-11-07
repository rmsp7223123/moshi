package com.example.moshi

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    const val API_KEY = "              ";

    private val okHttpClient: OkHttpClient by lazy {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build();
    };

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)    // Logcat에서 패킷 내용을 로그로 남기는 속성
            .baseUrl("https://openapi.gg.go.kr/")
            .build();
    };

    val retrofitService: RetrofitService by lazy {
        retrofit.create(RetrofitService::class.java);
    };
};

