package com.jmyebenes.curriculum.data

import com.jmyebenes.curriculum.data.model.toDomain
import com.jmyebenes.curriculum.data.network.AboutService
import com.jmyebenes.curriculum.domain.AboutRepository
import com.jmyebenes.curriculum.domain.model.AboutModel
import javax.inject.Inject

class AboutRepositoryImpl @Inject constructor(private val aboutService: AboutService) :
    AboutRepository {

    override suspend fun getAboutData(): AboutModel {
        return aboutService.getAboutData().toDomain()
    }

}
