package com.cloudhumans.chcoreapi.unit

import com.cloudhumans.chcoreapi.utils.ApplicationCalculator
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ApplicationCalculatorUnitTests {

    // PAST EXPERIENCE
    @Test
    @DisplayName("Asserts grade for sales experience")
    fun `Asserts that calculator grades sales experience correctly`() {
        assert(ApplicationCalculator.PAST_EXPERIENCES.apply(sales = true, support = false) == 5)
    }

    @Test
    @DisplayName("Asserts grade for support experience")
    fun `Asserts that calculator grades support experience correctly`() {
        assert(ApplicationCalculator.PAST_EXPERIENCES.apply(sales = false, support = true) == 3)
    }

    @Test
    @DisplayName("Asserts grade for sales and support experience")
    fun `Asserts that calculator grades all experiences correctly`() {
        assert(ApplicationCalculator.PAST_EXPERIENCES.apply(sales = true, support = true) == 8)
    }

    @Test
    @DisplayName("Asserts grade for no experience")
    fun `Asserts that calculator grades none experience correctly`() {
        assert(ApplicationCalculator.PAST_EXPERIENCES.apply(sales = false, support = false) == 0)
    }

    // INTERNET
    @Test
    @DisplayName("Asserts grade a perfect internet connection correctly")
    fun `Asserts that calculator grades a perfect internet connection`() {
        assert(ApplicationCalculator.INTERNET_SCORE.apply(download = 51f, upload = 51f) == 2)
    }

    @Test
    @DisplayName("Asserts grade a perfect download speed but poor upload")
    fun `Asserts that calculator grades download speed`() {
        assert(ApplicationCalculator.INTERNET_SCORE.apply(download = 51f, upload = 4f) == 0)
    }

    @Test
    @DisplayName("Asserts grade a poor download speed but perfect upload")
    fun `Asserts that calculator grades upload speed`() {
        assert(ApplicationCalculator.INTERNET_SCORE.apply(download = 4f, upload = 51f) == 0)
    }

    @Test
    @DisplayName("Asserts grade a poor download speed and poor upload")
    fun `Asserts that calculator grades poor connection`() {
        assert(ApplicationCalculator.INTERNET_SCORE.apply(download = 4f, upload = 4f) == -2)
    }

    @Test
    @DisplayName("Asserts grade a random internet connection correctly")
    fun `Asserts that calculator grades random connection`() {
        val download = 1f + Math.random() * (51f - 1f)
        val upload = 1f + Math.random() * (51f - 1f)
        var result = 0

        if (download > 50) result += 1
        if (upload > 50) result += 1
        if (download < 5) result += -1
        if (upload < 5) result += -1

        assert(
            ApplicationCalculator.INTERNET_SCORE.apply(
                download = download.toFloat(),
                upload = upload.toFloat()
            ) == result
        )
    }

    // WRITING SCORE
    @Test
    @DisplayName("Asserts grade for low writing score")
    fun `Asserts that calculator grades low writing score`() {
        assert(ApplicationCalculator.WRITING_SCORE.apply(0.2f) == -1)
    }

    @Test
    @DisplayName("Asserts grade for low minimum writing score")
    fun `Asserts that calculator grades low minimum writing score`() {
        assert(ApplicationCalculator.WRITING_SCORE.apply(0.3f) == 1)
    }

    @Test
    @DisplayName("Asserts grade for low minimum writing score")
    fun `Asserts that calculator grades low maximum writing score`() {
        assert(ApplicationCalculator.WRITING_SCORE.apply(0.7f) == 1)
    }

    @Test
    @DisplayName("Asserts grade for high writing score")
    fun `Asserts that calculator grades high writing score`() {
        assert(ApplicationCalculator.WRITING_SCORE.apply(0.8f) == 2)
    }

    // REFERRAL CODE
    @Test
    @DisplayName("Assert that referral code is valid")
    fun `Asserts that calculator accepts the right referral code`() {
        assert(ApplicationCalculator.REFERRAL_CODE.apply("token1234") == 1)
    }

    @Test
    @DisplayName("Assert that referral code is invalid")
    fun `Asserts that calculator rejects the wrong referral code`() {
        assert(ApplicationCalculator.REFERRAL_CODE.apply("token12345") == 0)
    }

    @Test
    @DisplayName("Assert that referral code is case sensitive")
    fun `Asserts that calculator referral code is case sensitive`() {
        assert(ApplicationCalculator.REFERRAL_CODE.apply("TOKEN123") == 0)
    }
}
