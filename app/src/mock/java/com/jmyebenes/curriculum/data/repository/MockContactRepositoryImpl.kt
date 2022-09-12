package com.jmyebenes.curriculum.data.repository

import com.jmyebenes.curriculum.data.model.ContactEntity
import com.jmyebenes.curriculum.data.model.toDomain
import com.jmyebenes.curriculum.data.network.ContactService
import com.jmyebenes.curriculum.domain.ContactRepository
import com.jmyebenes.curriculum.domain.model.ContactModel
import javax.inject.Inject

class MockContactRepositoryImpl @Inject constructor(private val contactService: ContactService) :
    ContactRepository {

    override suspend fun getContactData(): List<ContactModel> {
        return arrayListOf(
            ContactEntity(
                image = "",
                text = "666666666",
                type = "phone"
            ),
            ContactEntity(
                image = "",
                text = "mail@gmail.com",
                type = "mail"
            ),
            ContactEntity(
                image = "",
                text = "github.com/mock",
                type = "link"
            ),
            ContactEntity(
                image = "",
                text = "www.linkedin.com/in/mock/",
                type = "link"
            )
        ).map { it.toDomain() }
    }

}
