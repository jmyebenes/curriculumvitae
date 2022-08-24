package com.jmyebenes.curriculum.data.model

import com.google.gson.annotations.SerializedName
import com.jmyebenes.curriculum.domain.model.ContactModel
import com.jmyebenes.curriculum.domain.model.ContactType

data class ContactEntity(
    @SerializedName("image")
    val image: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("type")
    val type: String
)

fun ContactEntity.toDomain(): ContactModel {
    return ContactModel(image, text, ContactType.fromString(type))
}