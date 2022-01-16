package com.cloudhumans.chcoreapi.controller

import com.cloudhumans.chcoreapi.domain.ProEvaluation
import com.cloudhumans.chcoreapi.domain.exception.CloudHumansException
import com.cloudhumans.chcoreapi.domain.exception.CloudHumansManagedError
import com.cloudhumans.chcoreapi.service.ProService
import com.cloudhumans.chcoreapi.service.dto.ProApplicationDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pro")
class ProApplicationController(private val proService: ProService) {

    @PostMapping("/application")
    fun evaluateApplication(@RequestBody applicationDTO: ProApplicationDTO): ResponseEntity<ProEvaluation> {
        return ResponseEntity.ok().body(proService.evaluateApplication(applicationDTO))
    }

    @ExceptionHandler(CloudHumansException::class)
    fun handleException(exception: CloudHumansException): ResponseEntity<CloudHumansManagedError> {
        return ResponseEntity.badRequest().body(CloudHumansManagedError(exception.message))
    }
}
