package com.jmyebenes.curriculum.data.network

import com.jmyebenes.curriculum.data.model.AboutEntity
import retrofit2.http.GET

interface AboutApi {

    @GET("about.json")
    suspend fun getAboutData(): AboutEntity
}