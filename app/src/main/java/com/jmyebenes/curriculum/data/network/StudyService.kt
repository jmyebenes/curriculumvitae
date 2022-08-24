package com.jmyebenes.curriculum.data.network

import com.jmyebenes.curriculum.core.RetrofitHelper
import com.jmyebenes.curriculum.data.model.StudyEntity

class StudyService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getStudyData(): List<StudyEntity> {
        return retrofit.create(StudyApi::class.java).getStudyData()
    }

}