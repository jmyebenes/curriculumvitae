package com.jmyebenes.curriculum.domain

import com.jmyebenes.curriculum.domain.model.AboutModel
import com.jmyebenes.curriculum.domain.model.ContactModel
import com.jmyebenes.curriculum.domain.model.StudyModel
import com.jmyebenes.curriculum.domain.model.WorkModel

interface DataRepository {
    suspend fun getAboutData(): AboutModel
    suspend fun getWorkData(): List<WorkModel>
    suspend fun getStudiesData(): List<StudyModel>
    suspend fun getContactData(): List<ContactModel>
}