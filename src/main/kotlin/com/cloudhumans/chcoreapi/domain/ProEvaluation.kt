package com.cloudhumans.chcoreapi.domain

import com.cloudhumans.chcoreapi.service.dto.ProApplicationDTO
import java.util.UUID

class ProEvaluation(application: ProApplicationDTO) {
    var id: UUID? = null
    var score: Int? = null
    var selectedProject: Project? = null
    var elegibleProjects: MutableList<Project>? = null
    var inelegibleProjects: MutableList<Project>? = null

    init {
        this.id = UUID.randomUUID()
        var grade = 0

        if (application.pastExperiences.sales) {
            grade += 5
        }

        if (application.pastExperiences.support) {
            grade += 3
        }
    }
}
