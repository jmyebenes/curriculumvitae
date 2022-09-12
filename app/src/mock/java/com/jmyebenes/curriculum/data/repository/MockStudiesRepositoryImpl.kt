package com.jmyebenes.curriculum.data.repository

import com.jmyebenes.curriculum.data.model.StudyEntity
import com.jmyebenes.curriculum.data.model.toDomain
import com.jmyebenes.curriculum.data.network.StudyService
import com.jmyebenes.curriculum.domain.StudiesRepository
import com.jmyebenes.curriculum.domain.model.StudyModel
import javax.inject.Inject

class MockStudiesRepositoryImpl @Inject constructor(private val studyService: StudyService) :
    StudiesRepository {

    override suspend fun getStudiesData(): List<StudyModel> {
        return arrayListOf(
            StudyEntity(
                level = "FPII",
                name = "Técnico Superior Mock",
                school = "IES Mock",
                initDate = "01/01/2004",
                endDate = "31/12/2006"
            ),
            StudyEntity(
                level = "FPI",
                name = "Técnico Mock",
                school = "IES Mock",
                initDate = "01/01/2002",
                endDate = "31/12/2004"
            )
        ).map { it.toDomain() }
    }

}
