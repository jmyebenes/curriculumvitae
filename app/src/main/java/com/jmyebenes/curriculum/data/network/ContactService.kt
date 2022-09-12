package com.jmyebenes.curriculum.data.network

import com.jmyebenes.curriculum.data.model.ContactEntity
import retrofit2.Retrofit
import javax.inject.Inject

class ContactService @Inject constructor(private val retrofit: Retrofit) {

    suspend fun getContactData(): List<ContactEntity> {
        return retrofit.create(ContactApi::class.java).getContactData()
    }

}