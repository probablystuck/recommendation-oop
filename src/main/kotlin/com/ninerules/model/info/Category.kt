package com.ninerules.model.info

data class Category(
    val id: String,
    val owner: String,
    val name: String,
    // ids of categories related to category
    val subcategories: List<String>,
    val classification: Classification
)
