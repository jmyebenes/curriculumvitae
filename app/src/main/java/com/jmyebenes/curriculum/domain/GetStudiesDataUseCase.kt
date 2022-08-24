package com.jmyebenes.curriculum.domain

import com.jmyebenes.curriculum.core.BaseUseCase
import com.jmyebenes.curriculum.data.DataRepository
import com.jmyebenes.curriculum.domain.model.StudyModel

class GetStudiesDataUseCase : BaseUseCase<Unit, List<StudyModel>>() {
    override suspend fun useCaseFunction(input: Unit): List<StudyModel> {
        return DataRepository.getStudiesData()
    }
}