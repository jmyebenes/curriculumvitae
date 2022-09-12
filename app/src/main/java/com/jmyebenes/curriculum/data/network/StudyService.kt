package com.jmyebenes.curriculum.data.network

import com.jmyebenes.curriculum.data.model.StudyEntity
import retrofit2.Retrofit
import javax.inject.Inject

class StudyService @Inject constructor(private val retrofit: Retrofit) {

    suspend fun getStudyData(): List<StudyEntity> {
        return retrofit.create(StudyApi::class.java).getStudyData()
    }

}