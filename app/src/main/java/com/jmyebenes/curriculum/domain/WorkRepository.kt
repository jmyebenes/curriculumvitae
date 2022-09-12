package com.jmyebenes.curriculum.domain

import com.jmyebenes.curriculum.domain.model.WorkModel

interface WorkRepository {
    suspend fun getWorkData(): List<WorkModel>
}