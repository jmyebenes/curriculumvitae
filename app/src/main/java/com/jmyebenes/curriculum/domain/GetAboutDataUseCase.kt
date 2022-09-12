package com.jmyebenes.curriculum.domain

import com.jmyebenes.curriculum.core.BaseUseCase
import com.jmyebenes.curriculum.domain.model.AboutModel
import javax.inject.Inject

class GetAboutDataUseCase @Inject constructor(private val aboutRepository: AboutRepository) :
    BaseUseCase<Unit, AboutModel>() {
    override suspend fun useCaseFunction(input: Unit): AboutModel {
        return aboutRepository.getAboutData()
    }
}