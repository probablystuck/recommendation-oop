package com.ninerules.model

import com.ninerules.model.info.Action
import com.ninerules.model.info.Rating
import java.time.Instant

data class Recommendation(
    val id: String,
    val title: String,
    val recommender: User,
    val actionItem: Action,
    val dateRecommended: Instant,
    val rating: Rating
)