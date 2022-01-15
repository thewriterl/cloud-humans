package com.cloudhumans.chcoreapi.domain

import com.cloudhumans.chcoreapi.service.dto.ProApplicationDTO
import com.cloudhumans.chcoreapi.utils.ApplicationCalculator
import java.util.UUID

class ProEvaluation(application: ProApplicationDTO) {
    var id: UUID? = null
    var score: Int = 0
    var selectedProject: Project? = null
    var elegibleProjects: MutableList<Project>? = null
    var inelegibleProjects: MutableList<Project>? = null

    init {
        this.id = UUID.randomUUID()
        this.score = 0

        this.score += ApplicationCalculator.INTERNET_SCORE.apply(
            application.internetTest.downloadSpeed,
            application.internetTest.uploadSpeed
        )
        this.score += ApplicationCalculator.PAST_EXPERIENCES.apply(
            application.pastExperiences.sales,
            application.pastExperiences.support
        )
        this.score += ApplicationCalculator.WRITING_SCORE.apply(application.writingScore)
        this.score += ApplicationCalculator.REFERRAL_CODE.apply(application.referralCode)

        this.elegibleProjects = Project.values().filter { project ->
            this.score >= project.minimumScore
        }.toMutableList()

        this.inelegibleProjects = Project.values().filter { project ->
            this.score <= project.minimumScore
        }.toMutableList()

        this.selectedProject = this.elegibleProjects?.maxByOrNull { project -> project.minimumScore }
    }
}
