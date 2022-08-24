package com.jmyebenes.curriculum.data.network

import com.jmyebenes.curriculum.data.model.WorkEntity
import retrofit2.http.GET

interface WorkApi {

    @GET("work.json")
    suspend fun getWorkData(): List<WorkEntity>
}