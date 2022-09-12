package com.jmyebenes.curriculum.domain

import com.jmyebenes.curriculum.core.BaseUseCase
import com.jmyebenes.curriculum.domain.model.ContactModel
import javax.inject.Inject

class GetContactDataUseCase @Inject constructor(private val contactRepository: ContactRepository) :
    BaseUseCase<Unit, List<ContactModel>>() {
    override suspend fun useCaseFunction(input: Unit): List<ContactModel> {
        return contactRepository.getContactData()
    }
}