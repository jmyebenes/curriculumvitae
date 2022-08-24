package com.jmyebenes.curriculum.domain.model

import com.jmyebenes.curriculum.data.model.AboutEntity

data class AboutModel(
    val image: String = "",
    val location: String = "",
    val title: String = "",
    val description: String = ""
)

fun AboutModel.toEntity(): AboutEntity {
    return AboutEntity(image, location, title, description)
}