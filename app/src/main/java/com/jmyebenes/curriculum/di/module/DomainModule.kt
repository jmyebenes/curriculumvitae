package com.jmyebenes.curriculum.di.module

import com.jmyebenes.curriculum.data.network.AboutService
import com.jmyebenes.curriculum.data.network.ContactService
import com.jmyebenes.curriculum.data.network.StudyService
import com.jmyebenes.curriculum.data.network.WorkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun aboutServiceProvider(retrofit: Retrofit) = AboutService(retrofit)

    @Provides
    @Singleton
    fun workServiceProvider(retrofit: Retrofit) = WorkService(retrofit)

    @Provides
    @Singleton
    fun studyServiceProvider(retrofit: Retrofit) = StudyService(retrofit)

    @Provides
    @Singleton
    fun contactServiceProvider(retrofit: Retrofit) = ContactService(retrofit)

}