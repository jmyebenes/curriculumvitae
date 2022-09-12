package com.jmyebenes.curriculum.data.network

import com.jmyebenes.curriculum.data.model.AboutEntity
import retrofit2.Retrofit
import javax.inject.Inject

class AboutService @Inject constructor(private val retrofit: Retrofit) {

    suspend fun getAboutData(): AboutEntity {
        return retrofit.create(AboutApi::class.java).getAboutData()
    }

}