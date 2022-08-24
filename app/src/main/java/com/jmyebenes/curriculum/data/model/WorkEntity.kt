package com.jmyebenes.curriculum.data.model

import com.google.gson.annotations.SerializedName
import com.jmyebenes.curriculum.domain.model.WorkModel

data class WorkEntity(
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
    val description: String?,
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("projects")
    val projects: List<ProjectEntity> = listOf()
)

fun WorkEntity.toDomain(): WorkModel {
    return WorkModel(
        image,
        name,
        initDate,
        endDate,
        position,
        description,
        active,
        projects.map { it.toDomain() }
    )
}