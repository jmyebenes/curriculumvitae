package com.jmyebenes.curriculum.data

import com.jmyebenes.curriculum.data.model.toDomain
import com.jmyebenes.curriculum.data.network.ContactService
import com.jmyebenes.curriculum.domain.ContactRepository
import com.jmyebenes.curriculum.domain.model.ContactModel
import javax.inject.Inject

class ContactRepositoryImpl @Inject constructor(private val contactService: ContactService) : ContactRepository {

    override suspend fun getContactData(): List<ContactModel> {
        return contactService.getContactData().map { it.toDomain() }
    }

}
