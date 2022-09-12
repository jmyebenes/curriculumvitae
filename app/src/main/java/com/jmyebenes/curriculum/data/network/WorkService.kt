package com.jmyebenes.curriculum.data.network

import com.jmyebenes.curriculum.data.model.WorkEntity
import retrofit2.Retrofit
import javax.inject.Inject

class WorkService @Inject constructor(private val retrofit: Retrofit) {

    suspend fun getWorkData(): List<WorkEntity> {
        return retrofit.create(WorkApi::class.java).getWorkData()
    }

}