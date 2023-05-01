package com.ninerules.model

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey

@DynamoDbBean
data class User(
    @get:DynamoDbPartitionKey
    var id: String? = null,
    var name: String? = null,
    // list of ids of RecommendationLists
    var lists: List<String>? = emptyList()
)
