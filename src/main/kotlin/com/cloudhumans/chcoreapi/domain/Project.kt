package com.cloudhumans.chcoreapi.domain

enum class Project(val minimumScore: Int, val externalName: String) {
    DARK_MATTER(minimumScore = 10, externalName = "calculate_dark_matter_nasa"),
    SCHRODINGER_CAT(minimumScore = 5, externalName = "determine_schrodinger_cat_is_alive"),
    SUPPORT_YXZ(minimumScore = 3, externalName = "support_users_from_xyz"),
    SOCIAL_MEDIA_XPTO(minimumScore = 2, externalName = "collect_information_for_xpto")
}
