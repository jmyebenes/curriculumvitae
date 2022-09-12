package com.jmyebenes.curriculum.data.repository

import com.jmyebenes.curriculum.data.model.ProjectEntity
import com.jmyebenes.curriculum.data.model.WorkEntity
import com.jmyebenes.curriculum.data.model.toDomain
import com.jmyebenes.curriculum.data.network.WorkService
import com.jmyebenes.curriculum.domain.WorkRepository
import com.jmyebenes.curriculum.domain.model.WorkModel
import javax.inject.Inject

class MockWorkRepositoryImpl @Inject constructor(private val workService: WorkService) :
    WorkRepository {

    override suspend fun getWorkData(): List<WorkModel> {
        return arrayListOf(
            WorkEntity(
                image = "",
                name = "Empresa Mock 1",
                initDate = "01/01/2020",
                endDate = "Actualmente",
                position = "Desarrollador Mock",
                description = "Consultora",
                active = true,
                projects = arrayListOf(
                    ProjectEntity(
                        image = "",
                        name = "Proyecto Mock 1",
                        initDate = "01/01/2020",
                        endDate = "31/12/2022",
                        position = "Desarrollador Mock",
                        description = "Descripción Mock",
                        technologies = "Tecnología Mock 1, Tecnología Mock 2"
                    ),
                    ProjectEntity(
                        image = "",
                        name = "Proyecto Mock 2",
                        initDate = "01/01/2020",
                        endDate = "31/12/2022",
                        position = "Desarrollador Mock",
                        description = "Descripción Mock",
                        technologies = "Tecnología Mock 1, Tecnología Mock 2"
                    ),
                    ProjectEntity(
                        image = "",
                        name = "Proyecto Mock 3",
                        initDate = "01/01/2020",
                        endDate = "31/12/2022",
                        position = "Desarrollador Mock",
                        description = "Descripción Mock",
                        technologies = "Tecnología Mock 1, Tecnología Mock 2"
                    )
                )
            ),
            WorkEntity(
                image = "",
                name = "Empresa Mock 2",
                initDate = "01/01/2006",
                endDate = "01/01/2020",
                position = "Desarrollador Mock",
                description = "Consultora",
                active = false,
                projects = arrayListOf(
                    ProjectEntity(
                        image = "",
                        name = "Proyecto Mock 1",
                        initDate = "01/01/2020",
                        endDate = "31/12/2022",
                        position = "Desarrollador Mock",
                        description = "Descripción Mock",
                        technologies = "Tecnología Mock 1, Tecnología Mock 2"
                    ),
                )
            )
        )
            .map { it.toDomain() }
    }

}
