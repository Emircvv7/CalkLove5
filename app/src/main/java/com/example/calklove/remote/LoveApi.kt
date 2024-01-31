package com.example.calklove.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun getCompatibility(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "430fb75a10mshfcc71425c2299a2p1c9d10jsnf97a40982b8d",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com",
    ) : Call<LoveModel>
}
