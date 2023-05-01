package com.ninerules.model.response

data class NewUserResponse(
    val id: String,
    val name: String,
    val lists: List<String> = emptyList()
)