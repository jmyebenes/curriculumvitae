package com.jmyebenes.curriculum.data.model

import com.google.gson.annotations.SerializedName
import com.jmyebenes.curriculum.domain.model.ProjectModel

data class ProjectEntity(
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("initDate")
    val initDate: String,
    @SerializedName("endDate")
    val endDate: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("technologies")
    val technologies: String,
)

fun ProjectEntity.toDomain(): ProjectModel {
    return ProjectModel(image, name, initDate, endDate, position, description, technologies)
}