package com.cloudhumans.chcoreapi.controller

import com.cloudhumans.chcoreapi.domain.exception.CloudHumansException
import com.cloudhumans.chcoreapi.domain.exception.CloudHumansManagedError
import com.cloudhumans.chcoreapi.service.ProService
import com.cloudhumans.chcoreapi.service.dto.ApplicationEvaluationDTO
import com.cloudhumans.chcoreapi.service.dto.ProApplicationDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pro")
class ProApplicationController(private val proService: ProService) {

    @PostMapping("/application")
    fun evaluateApplication(@RequestBody applicationDTO: ProApplicationDTO): ApplicationEvaluationDTO {
        return proService.evaluateApplication(applicationDTO)
    }

    @ExceptionHandler(CloudHumansException::class)
    fun handleException(exception: CloudHumansException): CloudHumansManagedError {
        return CloudHumansManagedError(exception.message)
    }
}
