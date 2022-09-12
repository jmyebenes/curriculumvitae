package com.jmyebenes.curriculum.domain

import com.jmyebenes.curriculum.domain.model.StudyModel

interface StudiesRepository {
    suspend fun getStudiesData(): List<StudyModel>
}