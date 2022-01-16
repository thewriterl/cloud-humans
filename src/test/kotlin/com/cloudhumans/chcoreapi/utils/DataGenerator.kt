package com.cloudhumans.chcoreapi.utils

import com.cloudhumans.chcoreapi.utils.dto.InternetTestDTO

class DataGenerator {

    fun generateInternetTestData(): InternetTestDTO {
        val download = 1f + Math.random() * (51f - 1f)
        val upload = 1f + Math.random() * (51f - 1f)
        var result = 0

        if (download > 50) result += 1
        if (upload > 50) result += 1
        if (download < 5) result += -1
        if (upload < 5) result += -1

        return InternetTestDTO(
            download = download.toFloat(),
            upload = upload.toFloat(),
            result = result
        )
    }
}
