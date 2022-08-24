package com.jmyebenes.curriculum.domain

import com.jmyebenes.curriculum.core.BaseUseCase
import com.jmyebenes.curriculum.data.DataRepository
import com.jmyebenes.curriculum.domain.model.AboutModel

class GetAboutDataUseCase : BaseUseCase<Unit, AboutModel>() {
    override suspend fun useCaseFunction(input: Unit): AboutModel {
        return DataRepository.getAboutData()
    }
}