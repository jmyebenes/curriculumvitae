package com.jmyebenes.curriculum.domain.model

import com.jmyebenes.curriculum.data.model.StudyEntity

data class StudyModel(
    val level: String = "",
    val name: String = "",
    val school: String = "",
    val initDate: String = "",
    val endDate: String = ""
)

fun StudyModel.toEntity(): StudyEntity {
    return StudyEntity(level, name, school, initDate, endDate)
}