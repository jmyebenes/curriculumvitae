package com.jmyebenes.curriculum.data.model

import com.google.gson.annotations.SerializedName
import com.jmyebenes.curriculum.domain.model.StudyModel

data class StudyEntity(
    @SerializedName("level")
    val level: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("school")
    val school: String,
    @SerializedName("initDate")
    val initDate: String,
    @SerializedName("endDate")
    val endDate: String,
)

fun StudyEntity.toDomain(): StudyModel {
    return StudyModel(level, name, school, initDate, endDate)
}