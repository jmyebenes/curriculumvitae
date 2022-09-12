package com.jmyebenes.curriculum.domain

import com.jmyebenes.curriculum.core.BaseUseCase
import com.jmyebenes.curriculum.domain.model.WorkModel
import javax.inject.Inject

class GetWorkDataUseCase @Inject constructor(private val workRepository: WorkRepository) :
    BaseUseCase<Unit, List<WorkModel>>() {
    override suspend fun useCaseFunction(input: Unit): List<WorkModel> {
        return workRepository.getWorkData()
    }
}