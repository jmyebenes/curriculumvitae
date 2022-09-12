package com.jmyebenes.curriculum.data

import com.jmyebenes.curriculum.data.model.toDomain
import com.jmyebenes.curriculum.data.network.StudyService
import com.jmyebenes.curriculum.domain.StudiesRepository
import com.jmyebenes.curriculum.domain.model.StudyModel
import javax.inject.Inject

class StudiesRepositoryImpl @Inject constructor(private val studyService: StudyService): StudiesRepository {

    override suspend fun getStudiesData(): List<StudyModel> {
        return studyService.getStudyData().map { it.toDomain() }
    }

}
