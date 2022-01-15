package com.cloudhumans.chcoreapi.service.impl

import com.cloudhumans.chcoreapi.domain.ProEvaluation
import com.cloudhumans.chcoreapi.service.ProService
import com.cloudhumans.chcoreapi.service.dto.ProApplicationDTO
import com.cloudhumans.chcoreapi.service.dto.validateProApplication
import org.springframework.stereotype.Service

@Service
class ProServiceImpl : ProService {

    override fun evaluateApplication(application: ProApplicationDTO): ProEvaluation {
        application.validateProApplication()
        return ProEvaluation(application)
    }
}
