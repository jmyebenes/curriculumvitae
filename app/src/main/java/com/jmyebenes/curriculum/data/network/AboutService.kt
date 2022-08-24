package com.jmyebenes.curriculum.data.network

import com.jmyebenes.curriculum.core.RetrofitHelper
import com.jmyebenes.curriculum.data.model.AboutEntity

class AboutService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAboutData(): AboutEntity {
        return retrofit.create(AboutApi::class.java).getAboutData()
    }

}