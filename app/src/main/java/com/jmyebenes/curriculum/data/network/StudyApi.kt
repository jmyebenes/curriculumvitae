package com.jmyebenes.curriculum.data.network

import com.jmyebenes.curriculum.data.model.StudyEntity
import retrofit2.http.GET

interface StudyApi {

    @GET("study.json")
    suspend fun getStudyData(): List<StudyEntity>
}