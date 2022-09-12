package com.jmyebenes.curriculum.di.module

import com.jmyebenes.curriculum.data.repository.MockAboutRepositoryImpl
import com.jmyebenes.curriculum.data.repository.MockContactRepositoryImpl
import com.jmyebenes.curriculum.data.repository.MockStudiesRepositoryImpl
import com.jmyebenes.curriculum.data.repository.MockWorkRepositoryImpl
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
    abstract fun bindAboutRepository(aboutRepositoryImpl: MockAboutRepositoryImpl): AboutRepository

    @Binds
    abstract fun bindWorkRepository(workRepositoryImpl: MockWorkRepositoryImpl): WorkRepository

    @Binds
    abstract fun bindStudyRepository(studyRepositoryImpl: MockStudiesRepositoryImpl): StudiesRepository

    @Binds
    abstract fun bindContactRepository(contactRepositoryImpl: MockContactRepositoryImpl): ContactRepository
}