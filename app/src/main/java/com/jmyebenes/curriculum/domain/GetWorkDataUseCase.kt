package com.jmyebenes.curriculum.domain

import com.jmyebenes.curriculum.core.BaseUseCase
import com.jmyebenes.curriculum.data.DataRepository
import com.jmyebenes.curriculum.domain.model.WorkModel

class GetWorkDataUseCase : BaseUseCase<Unit, List<WorkModel>>() {
    override suspend fun useCaseFunction(input: Unit): List<WorkModel> {
        return DataRepository.getWorkData()
    }
}