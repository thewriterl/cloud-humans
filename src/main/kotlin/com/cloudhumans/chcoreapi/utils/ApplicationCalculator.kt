package com.cloudhumans.chcoreapi.utils

import com.cloudhumans.chcoreapi.domain.exception.CloudHumansException

enum class ApplicationCalculator {
    PAST_EXPERIENCES {
        @Deprecated(
            "Not Applicable to this Field",
            ReplaceWith("apply(sales: Boolean, support:Boolean)"),
            level = DeprecationLevel.ERROR
        )
        override fun apply(download: Float, upload: Float): Int {
            throw CloudHumansException("Wrongful implementation of  calculator")
        }

        override fun apply(sales: Boolean, support: Boolean): Int {
            var result = 0
            if (sales) result += 5
            if (support) result += 3
            return result
        }

        @Deprecated(
            "Not Applicable to this Field",
            ReplaceWith("apply(sales: Boolean, support:Boolean)"),
            level = DeprecationLevel.ERROR
        )
        override fun apply(writingScore: Float): Int {
            throw CloudHumansException("Wrongful implementation of  calculator")
        }

        @Deprecated(
            "Not Applicable to this Field",
            ReplaceWith("apply(sales: Boolean, support:Boolean)"),
            level = DeprecationLevel.ERROR
        )
        override fun apply(token: String): Int {
            throw CloudHumansException("Wrongful implementation of  calculator")
        }
    },
    INTERNET_SCORE {
        override fun apply(download: Float, upload: Float): Int {
            var result = 0
            if (download > 50 || upload > 50) result += 1
            if (download < 5 || upload < 5) result += -1
            return result
        }

        @Deprecated(
            "Not Applicable to this Field",
            ReplaceWith("apply(download: Int, upload: Int)"),
            level = DeprecationLevel.ERROR
        )
        override fun apply(sales: Boolean, support: Boolean): Int {
            throw CloudHumansException("Wrongful implementation of  calculator")
        }

        @Deprecated(
            "Not Applicable to this Field",
            ReplaceWith("apply(download: Int, upload: Int)"),
            level = DeprecationLevel.ERROR
        )
        override fun apply(writingScore: Float): Int {
            throw CloudHumansException("Wrongful implementation of  calculator")
        }

        @Deprecated(
            "Not Applicable to this Field",
            ReplaceWith("apply(download: Int, upload: Int)"),
            level = DeprecationLevel.ERROR
        )
        override fun apply(token: String): Int {
            throw CloudHumansException("Wrongful implementation of  calculator")
        }
    },
    WRITING_SCORE {
        @Deprecated(
            "Not Applicable to this Field",
            ReplaceWith("apply(download: Int, upload: Int)"),
            level = DeprecationLevel.ERROR
        )
        override fun apply(download: Float, upload: Float): Int {
            throw CloudHumansException("Wrongful implementation of  calculator")
        }

        @Deprecated(
            "Not Applicable to this Field",
            ReplaceWith("apply(download: Int, upload: Int)"),
            level = DeprecationLevel.ERROR
        )
        override fun apply(sales: Boolean, support: Boolean): Int {
            throw CloudHumansException("Wrongful implementation of  calculator")
        }

        override fun apply(writingScore: Float): Int {
            var result = 0
            if (writingScore < 0.3) result += -1
            if (writingScore in 0.3..0.7) result += 1
            if (writingScore > 0.4) result += 2
            return result
        }

        @Deprecated(
            "Not Applicable to this Field",
            ReplaceWith("apply(download: Int, upload: Int)"),
            level = DeprecationLevel.ERROR
        )
        override fun apply(token: String): Int {
            throw CloudHumansException("Wrongful implementation of  calculator")
        }
    },
    REFERRAL_CODE {
        @Deprecated(
            "Not Applicable to this Field",
            ReplaceWith("apply(download: Int, upload: Int)"),
            level = DeprecationLevel.ERROR
        )
        override fun apply(download: Float, upload: Float): Int {
            throw CloudHumansException("Wrongful implementation of  calculator")
        }

        @Deprecated(
            "Not Applicable to this Field",
            ReplaceWith("apply(download: Int, upload: Int)"),
            level = DeprecationLevel.ERROR
        )
        override fun apply(sales: Boolean, support: Boolean): Int {
            throw CloudHumansException("Wrongful implementation of  calculator")
        }

        @Deprecated(
            "Not Applicable to this Field",
            ReplaceWith("apply(download: Int, upload: Int)"),
            level = DeprecationLevel.ERROR
        )
        override fun apply(writingScore: Float): Int {
            throw CloudHumansException("Wrongful implementation of  calculator")
        }

        override fun apply(token: String): Int {
            return if (token.equals("token1234")) 1 else 0
        }
    };

    abstract fun apply(download: Float, upload: Float): Int
    abstract fun apply(sales: Boolean, support: Boolean): Int
    abstract fun apply(writingScore: Float): Int
    abstract fun apply(token: String): Int
}
