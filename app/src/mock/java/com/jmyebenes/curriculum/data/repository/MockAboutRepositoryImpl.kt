package com.jmyebenes.curriculum.data.repository

import com.jmyebenes.curriculum.data.model.AboutEntity
import com.jmyebenes.curriculum.data.model.toDomain
import com.jmyebenes.curriculum.data.network.AboutService
import com.jmyebenes.curriculum.domain.AboutRepository
import com.jmyebenes.curriculum.domain.model.AboutModel
import javax.inject.Inject

class MockAboutRepositoryImpl @Inject constructor(private val aboutService: AboutService) :
    AboutRepository {

    override suspend fun getAboutData(): AboutModel {
        return AboutEntity(
            image = "",
            location = "Mockeado",
            title = "Hola Mock!",
            description = "Descripción mock"
        ).toDomain()
    }

}
