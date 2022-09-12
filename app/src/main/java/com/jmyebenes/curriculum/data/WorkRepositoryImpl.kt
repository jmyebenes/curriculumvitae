package com.jmyebenes.curriculum.data

import com.jmyebenes.curriculum.data.model.toDomain
import com.jmyebenes.curriculum.data.network.AboutService
import com.jmyebenes.curriculum.data.network.ContactService
import com.jmyebenes.curriculum.data.network.StudyService
import com.jmyebenes.curriculum.data.network.WorkService
import com.jmyebenes.curriculum.domain.StudiesRepository
import com.jmyebenes.curriculum.domain.WorkRepository
import com.jmyebenes.curriculum.domain.model.AboutModel
import com.jmyebenes.curriculum.domain.model.ContactModel
import com.jmyebenes.curriculum.domain.model.StudyModel
import com.jmyebenes.curriculum.domain.model.WorkModel
import javax.inject.Inject

class WorkRepositoryImpl @Inject constructor(private val workService: WorkService) : WorkRepository {

    override suspend fun getWorkData(): List<WorkModel> {
        return workService.getWorkData().map { it.toDomain() }
    }

}
