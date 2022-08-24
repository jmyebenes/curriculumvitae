package com.jmyebenes.curriculum.data.model

import com.google.gson.annotations.SerializedName
import com.jmyebenes.curriculum.domain.model.AboutModel

data class AboutEntity(
    @SerializedName("image")
    val image: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String
)

fun AboutEntity.toDomain(): AboutModel {
    return AboutModel(image, location, title, description)
}
