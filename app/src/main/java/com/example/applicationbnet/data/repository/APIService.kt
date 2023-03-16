package com.example.applicationbnet.data.repository

import com.example.applicationbnet.data.Drug
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Single

interface APIService {

    @GET("api/ppp/item/")
    fun getDrug(@Query("id") id: Int): Single<Drug>

    @GET("api/ppp/index/")
    fun getDrugsList(@Query("search") search: String): Single<List<Drug>>

}