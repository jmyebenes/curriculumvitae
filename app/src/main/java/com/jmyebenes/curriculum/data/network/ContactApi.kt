package com.jmyebenes.curriculum.data.network

import com.jmyebenes.curriculum.data.model.ContactEntity
import retrofit2.http.GET

interface ContactApi {

    @GET("contact.json")
    suspend fun getContactData(): List<ContactEntity>
}