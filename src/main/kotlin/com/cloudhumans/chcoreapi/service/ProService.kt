package com.cloudhumans.chcoreapi.service

import com.cloudhumans.chcoreapi.domain.ProEvaluation
import com.cloudhumans.chcoreapi.service.dto.ApplicationEvaluationDTO
import com.cloudhumans.chcoreapi.service.dto.ProApplicationDTO

interface ProService {
    fun evaluateApplication(application: ProApplicationDTO): ProEvaluation
}
