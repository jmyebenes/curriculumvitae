package com.jmyebenes.curriculum.di.module

import com.jmyebenes.curriculum.core.RetrofitHelper
import com.jmyebenes.curriculum.data.network.AboutService
import com.jmyebenes.curriculum.data.network.ContactService
import com.jmyebenes.curriculum.data.network.StudyService
import com.jmyebenes.curriculum.data.network.WorkService
import com.jmyebenes.curriculum.domain.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    @Singleton
    fun retrofitProvider() = RetrofitHelper.getRetrofit()

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