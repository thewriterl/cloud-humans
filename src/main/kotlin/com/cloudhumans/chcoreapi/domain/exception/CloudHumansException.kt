package com.cloudhumans.chcoreapi.domain.exception

data class CloudHumansException(override val message: String?) : Exception(message)

data class CloudHumansManagedError(val message: String?)
