//package com.jmyebenes.curriculum.data
//
//import com.jmyebenes.curriculum.data.model.*
//import com.jmyebenes.curriculum.domain.DataRepository
//import com.jmyebenes.curriculum.domain.model.AboutModel
//import com.jmyebenes.curriculum.domain.model.ContactModel
//import com.jmyebenes.curriculum.domain.model.StudyModel
//import com.jmyebenes.curriculum.domain.model.WorkModel
//
//object MockRepository : DataRepository {
//
//    val studyData = arrayListOf(
//        StudyEntity(
//            "FPII",
//            "Técnico Superior en Desarrollo Multiplataformas",
//            "IES Azarquiel",
//            "01/01/2004",
//            "31/12/2006"
//        ),
//        StudyEntity(
//            "FPI",
//            "Técnico en Sistemas Microinformáticos y Redes",
//            "IES Cañada Real",
//            "01/01/2002",
//            "31/12/2004"
//        )
//    )
//
//    val contactData = arrayListOf(
//        ContactEntity(
//            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQENp_PcmZSEsi2chGwlZN0P1myWyH2DqQ1Sg&usqp=CAU",
//            "686323060",
//            "phone"
//        ),
//        ContactEntity(
//            "data:image/jpeg;base64,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",
//            "josemanuelyebenes@gmail.com",
//            "mail"
//        ),
//        ContactEntity(
//            "data:image/png;base64,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",
////                    "https://github.com/jmyebenes",
//            "github.com/jmyebenes",
//            "link"
//        ),
//        ContactEntity(
//            "data:image/png;base64,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",
////                    "https://www.linkedin.com/in/josemanuelyebenes/",
//            "www.linkedin.com/in/josemanuelyebenes/",
//            "link"
//        )
//    )
//
//    override suspend fun getAboutData(): AboutModel {
//        return AboutEntity(
//            "https://media-exp1.licdn.com/dms/image/C4D03AQF__fsy7w_Big/profile-displayphoto-shrink_800_800/0/1594800119739?e=1658966400&v=beta&t=jWMju8Zr1X-gAp7CMtJoL7xPcRUcomHMEl79UuMryXg",
//            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse!"
//        ).toDomain()
//    }
//
//    override suspend fun getWorkData(): ArrayList<WorkModel> {
//        return ArrayList(arrayListOf(
//            WorkEntity(
//                "https://media-exp1.licdn.com/dms/image/C560BAQEXJ-wc4GRmhA/company-logo_200_200/0/1649342414617?e=1661385600&v=beta&t=jJYqtDzBey_jYzzAjF6Iq9QuqbEUpQTt12wakLCABdk",
//                "Serbatic", "01/01/2020", "Actualmente", "Desarrollador Android", "Consultora", true,
//                arrayListOf(
//                    ProjectEntity("imagen", "Carrefour Pass", "fecha", "fecha", "posición", "descripción", "tecnología 1, tecnología 2"),
//                    ProjectEntity("imagen", "Vass App", "fecha", "fecha", "posición", "descripción", "tecnología 1, tecnología 2"),
//                    ProjectEntity("imagen", "Renault Bank", "fecha", "fecha", "posición", "descripción", "tecnología 1, tecnología 2")
//                )
//            ),
//            WorkEntity(
//                "https://media-exp1.licdn.com/dms/image/C4D0BAQHD41jdQmdz-A/company-logo_200_200/0/1542731746146?e=1661385600&v=beta&t=A--DdMx-aEIa6OgOlujPYHd6ZvyDGiF9gGH2H-6KYmk",
//                "Alvea", "01/01/2006", "01/01/2020", "Desarrollador Android", "Consultora", false,
//                arrayListOf(
//                    ProjectEntity("imagen", "Orange TV", "fecha", "fecha", "posición", "descripción", "tecnología 1, tecnología 2")
//                )
//            ),
//            WorkEntity(
//                "https://media-exp1.licdn.com/dms/image/C560BAQFYGMH7DbHn5g/company-logo_200_200/0/1646041980222?e=1661385600&v=beta&t=cFnJEm4qwOTDrvVZi4RlulwCHJ58b-KVIMFS-7EMY7M",
//                "Corim Solutions", "01/01/2006", "01/01/2020", "Desarrollador Web", "Consultora", false,
//                arrayListOf(
//                    ProjectEntity("imagen", "Corim SW", "fecha", "fecha", "posición", "descripción", "tecnología 1, tecnología 2")
//                )
//            ),
//            WorkEntity(
//                "https://media-exp1.licdn.com/dms/image/C4E03AQE6HVjFyeuNeA/profile-displayphoto-shrink_400_400/0/1516961382522?e=1658966400&v=beta&t=ZU7IHKTbzYJm3mP9Rkwn-e65x9-IO5KgmJRbUl013BY",
//                "Nutrytec", "01/01/2006", "01/01/2020", "Desarrollador Android/Web", "Consultora", false,
//                arrayListOf(
//                    ProjectEntity("imagen", "Logística", "fecha", "fecha", "posición", "descripción", "tecnología 1, tecnología 2")
//                )
//            )
//        ).map { it.toDomain() })
//    }
//
//    override suspend fun getStudiesData(): ArrayList<StudyModel> {
//
//    }
//
//    override suspend fun getContactData(): ArrayList<ContactModel> {
//
//    }
//}
