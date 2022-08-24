package com.jmyebenes.curriculum.domain.model

import com.jmyebenes.curriculum.data.model.WorkEntity
import java.io.Serializable

data class WorkModel(
    val image: String = "",
    val name: String = "",
    val initDate: String = "",
    val endDate: String = "",
    val position: String = "",
    val description: String? = "",
    val active: Boolean = false,
    val projects: List<ProjectModel> = listOf()
) : Serializable

fun WorkModel.toEntity(): WorkEntity {
    return WorkEntity(image, name, initDate, endDate, position, description, active)
}