package com.jmyebenes.curriculum.domain.model

import com.jmyebenes.curriculum.data.model.ContactEntity
import com.jmyebenes.curriculum.domain.model.ContactType.Companion.toStringValue

data class ContactModel(
    val image: String = "",
    val text: String = "",
    val type: ContactType = ContactType.UNKNOWN
)

fun ContactModel.toEntity(): ContactEntity {
    return ContactEntity(image, text, type.toStringValue())
}