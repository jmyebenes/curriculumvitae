package com.jmyebenes.curriculum.di.module

import com.jmyebenes.curriculum.data.AboutRepositoryImpl
import com.jmyebenes.curriculum.data.ContactRepositoryImpl
import com.jmyebenes.curriculum.data.StudiesRepositoryImpl
import com.jmyebenes.curriculum.data.WorkRepositoryImpl
import com.jmyebenes.curriculum.domain.AboutRepository
import com.jmyebenes.curriculum.domain.ContactRepository
import com.jmyebenes.curriculum.domain.StudiesRepository
import com.jmyebenes.curriculum.domain.WorkRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindAboutRepository(aboutRepositoryImpl: AboutRepositoryImpl): AboutRepository

    @Binds
    abstract fun bindWorkRepository(workRepositoryImpl: WorkRepositoryImpl): WorkRepository

    @Binds
    abstract fun bindStudyRepository(studyRepositoryImpl: StudiesRepositoryImpl): StudiesRepository

    @Binds
    abstract fun bindContactRepository(contactRepositoryImpl: ContactRepositoryImpl): ContactRepository
}