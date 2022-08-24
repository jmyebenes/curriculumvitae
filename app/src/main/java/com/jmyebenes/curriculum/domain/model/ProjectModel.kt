package com.jmyebenes.curriculum.domain.model

import com.jmyebenes.curriculum.data.model.ProjectEntity
import java.io.Serializable

data class ProjectModel(
    val image: String = "",
    val name: String = "",
    val initDate: String = "",
    val endDate: String = "",
    val position: String = "",
    val description: String = "",
    val technologies: String = "",
) : Serializable

fun ProjectModel.toEntity(): ProjectEntity {
    return ProjectEntity(image, name, initDate, endDate, position, description, technologies)
}