package com.jmyebenes.curriculum.domain

import com.jmyebenes.curriculum.core.BaseUseCase
import com.jmyebenes.curriculum.data.DataRepository
import com.jmyebenes.curriculum.domain.model.ContactModel

class GetContactDataUseCase : BaseUseCase<Unit, List<ContactModel>>() {
    override suspend fun useCaseFunction(input: Unit): List<ContactModel> {
        return DataRepository.getContactData()
    }
}