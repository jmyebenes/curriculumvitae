package com.jmyebenes.curriculum.data

import com.jmyebenes.curriculum.data.model.toDomain
import com.jmyebenes.curriculum.data.network.AboutService
import com.jmyebenes.curriculum.data.network.ContactService
import com.jmyebenes.curriculum.data.network.StudyService
import com.jmyebenes.curriculum.data.network.WorkService
import com.jmyebenes.curriculum.domain.DataRepository
import com.jmyebenes.curriculum.domain.model.AboutModel
import com.jmyebenes.curriculum.domain.model.ContactModel
import com.jmyebenes.curriculum.domain.model.StudyModel
import com.jmyebenes.curriculum.domain.model.WorkModel

object DataRepository : DataRepository {

    override suspend fun getAboutData(): AboutModel {
        return AboutService().getAboutData().toDomain()
    }

    override suspend fun getWorkData(): List<WorkModel> {
        return WorkService().getWorkData().map { it.toDomain() }
    }

    override suspend fun getStudiesData(): List<StudyModel> {
        return StudyService().getStudyData().map { it.toDomain() }
    }

    override suspend fun getContactData(): List<ContactModel> {
        return ContactService().getContactData().map { it.toDomain() }
    }

}
