package com.cloudhumans.chcoreapi.service.dto

import com.cloudhumans.chcoreapi.domain.exception.CloudHumansException
import com.fasterxml.jackson.annotation.JsonProperty

data class ProApplicationPastExperience(
    @JsonProperty("sales") val sales: Boolean,
    @JsonProperty("support") val support: Boolean
)

data class ProApplicationInternetTest(
    @JsonProperty("download_speed") val downloadSpeed: Float,
    @JsonProperty("upload_speed") val uploadSpeed: Float
)

data class ProApplicationDTO(
    @JsonProperty("age") val age: Int,
    @JsonProperty("education_level") val educationLevel: ProEducationLevel,
    @JsonProperty("past_experiences") val pastExperiences: ProApplicationPastExperience,
    @JsonProperty("internet_test") val internetTest: ProApplicationInternetTest,
    @JsonProperty("writing_score") val writingScore: Float,
    @JsonProperty("referral_code") val referralCode: String
)

enum class ProEducationLevel() {
    NO_EDUCATION,
    HIGH_SCHOOL,
    BACHELORS_OR_HIGH
}

fun ProApplicationDTO.validateProApplication() {
    if (this.age <= 0) {
        throw CloudHumansException("Invalid Age")
    }
    if (this.age < 18) {
        throw CloudHumansException("Invalid Age -- Pro is under age")
    }
    if (this.internetTest.downloadSpeed <= 0) {
        throw CloudHumansException("Invalid Download Speed")
    }
    if (this.internetTest.uploadSpeed <= 0) {
        throw CloudHumansException("Invalid Upload Speed")
    }
    if (this.writingScore < 0 || this.writingScore > 1) {
        throw CloudHumansException("Invalid Writing Score")
    }
}
