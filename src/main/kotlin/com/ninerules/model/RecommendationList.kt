package com.ninerules.model

import com.ninerules.model.info.Category

data class RecommendationList(
    val id: String,
    val owner: User,
    val category: Category,
    val recommendations: List<Recommendation>
)