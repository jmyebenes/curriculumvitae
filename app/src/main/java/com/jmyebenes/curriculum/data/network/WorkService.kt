package com.jmyebenes.curriculum.data.network

import com.jmyebenes.curriculum.core.RetrofitHelper
import com.jmyebenes.curriculum.data.model.WorkEntity
import retrofit2.Call

class WorkService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getWorkData(): List<WorkEntity> {
        return retrofit.create(WorkApi::class.java).getWorkData()
    }

}