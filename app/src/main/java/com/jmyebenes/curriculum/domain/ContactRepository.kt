package com.jmyebenes.curriculum.domain

import com.jmyebenes.curriculum.domain.model.ContactModel

interface ContactRepository {
    suspend fun getContactData(): List<ContactModel>
}