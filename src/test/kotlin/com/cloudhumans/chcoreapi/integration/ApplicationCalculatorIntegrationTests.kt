package com.cloudhumans.chcoreapi.integration

import com.cloudhumans.chcoreapi.ChCoreApiApplication
import com.cloudhumans.chcoreapi.domain.ProEvaluation
import com.cloudhumans.chcoreapi.service.dto.ProApplicationDTO
import com.cloudhumans.chcoreapi.service.dto.ProApplicationInternetTest
import com.cloudhumans.chcoreapi.service.dto.ProApplicationPastExperience
import com.cloudhumans.chcoreapi.service.dto.ProEducationLevel
import com.google.gson.Gson
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest(
    classes = arrayOf(ChCoreApiApplication::class),
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ExtendWith(SpringExtension::class)
@RunWith(SpringRunner::class)
class ApplicationCalculatorIntegrationTests {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    private val url = "/pro/application"

    @Test
    fun `should do a safe and standard application and assess its evaluation`() {
        val application = ProApplicationDTO(
            age = 35,
            educationLevel = ProEducationLevel.HIGH_SCHOOL,
            pastExperiences = ProApplicationPastExperience(sales = true, support = false),
            internetTest = ProApplicationInternetTest(downloadSpeed = 51f, uploadSpeed = 51f),
            writingScore = 0.8f,
            referralCode = "token1234"
        )
        val result = Gson().fromJson(
            restTemplate.postForObject(url, application, String::class.java),
            ProEvaluation::class.java
        )

        assertNotNull(result)
    }

    @Test
    fun `should fail for under aged applicant`() {
        val application = ProApplicationDTO(
            age = 16,
            educationLevel = ProEducationLevel.HIGH_SCHOOL,
            pastExperiences = ProApplicationPastExperience(sales = true, support = true),
            internetTest = ProApplicationInternetTest(downloadSpeed = 51f, uploadSpeed = 51f),
            writingScore = 0.8f,
            referralCode = "token1234"
        )

        val response = restTemplate.postForEntity(url, application, String::class.java)

        assertNotNull(response)
        assertEquals(HttpStatus.BAD_REQUEST, response?.statusCode)
    }

    @Test
    fun `should fail for lack of education and experience`() {
        val application = ProApplicationDTO(
            age = 16,
            educationLevel = ProEducationLevel.NO_EDUCATION,
            pastExperiences = ProApplicationPastExperience(sales = false, support = false),
            internetTest = ProApplicationInternetTest(downloadSpeed = 51f, uploadSpeed = 51f),
            writingScore = 0.8f,
            referralCode = "token1234"
        )

        val response = restTemplate.postForEntity(url, application, String::class.java)

        assertNotNull(response)
        assertEquals(HttpStatus.BAD_REQUEST, response?.statusCode)
    }

    @Test
    fun `should fail for lack of internet connection`() {
        val application = ProApplicationDTO(
            age = 16,
            educationLevel = ProEducationLevel.BACHELORS_OR_HIGH,
            pastExperiences = ProApplicationPastExperience(sales = false, support = false),
            internetTest = ProApplicationInternetTest(downloadSpeed = 4f, uploadSpeed = 4f),
            writingScore = 0.8f,
            referralCode = "token1234"
        )

        val response = restTemplate.postForEntity(url, application, String::class.java)

        assertNotNull(response)
        assertEquals(HttpStatus.BAD_REQUEST, response?.statusCode)
    }
}
