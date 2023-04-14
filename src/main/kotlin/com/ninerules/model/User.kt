package com.ninerules.model

data class User(
    val id: String,
    val name: String,
    // list of ids of RecommendationLists
    val lists: List<String>
)
