package com.jmyebenes.curriculum.data.network

import com.jmyebenes.curriculum.core.RetrofitHelper
import com.jmyebenes.curriculum.data.model.ContactEntity

class ContactService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getContactData(): List<ContactEntity> {
        return retrofit.create(ContactApi::class.java).getContactData()
    }

}