package com.jmyebenes.curriculum.domain

import com.jmyebenes.curriculum.domain.model.AboutModel

interface AboutRepository {
    suspend fun getAboutData(): AboutModel
}