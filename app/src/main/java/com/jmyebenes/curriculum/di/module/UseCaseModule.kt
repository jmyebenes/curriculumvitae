package com.jmyebenes.curriculum.di.module

import com.jmyebenes.curriculum.domain.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    @ViewModelScoped
    fun getAboutDataUseCaseProvider(aboutRepository: AboutRepository) =
        GetAboutDataUseCase(aboutRepository)

    @Provides
    @ViewModelScoped
    fun getWorkDataUseCaseProvider(workRepository: WorkRepository) =
        GetWorkDataUseCase(workRepository)

    @Provides
    @ViewModelScoped
    fun getStudyDataUseCaseProvider(studiesRepository: StudiesRepository) =
        GetStudiesDataUseCase(studiesRepository)

    @Provides
    @ViewModelScoped
    fun getContactDataUseCaseProvider(contactRepository: ContactRepository) =
        GetContactDataUseCase(contactRepository)

}