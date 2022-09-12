package com.jmyebenes.curriculum.domain

import com.jmyebenes.curriculum.core.BaseUseCase
import com.jmyebenes.curriculum.domain.model.StudyModel
import javax.inject.Inject

class GetStudiesDataUseCase @Inject constructor(private val studiesRepository: StudiesRepository) :
    BaseUseCase<Unit, List<StudyModel>>() {
    override suspend fun useCaseFunction(input: Unit): List<StudyModel> {
        return studiesRepository.getStudiesData()
    }
}