package com.ninerules.service

import com.ninerules.model.NewUserRequest
import com.ninerules.model.User
import io.micronaut.context.annotation.Property
import jakarta.inject.Singleton
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import java.util.*

@Singleton
class UserService(
    @Property(name = "dynamodb.table-name") val tableName: String
) {
    private val users = mutableListOf(
        User("1", "Manu", listOf())
    )

    fun getUsers() = users
    fun getUserInfoById(id: String) = users.find { it.id == id }
    fun getUserInfoByName(name: String) = users.find { it.name == name }

    // data doesnt persist remember, so these new users will only exist as long as the server is running
    fun createUserUnpersisted(newUserRequest: NewUserRequest) = users.add(
        User(
            id = (users.size + 1).toString(),
            name = newUserRequest.name,
            emptyList()
        )
    )

    fun createUser(request: NewUserRequest) {
        val newUser = User(UUID.randomUUID().toString(), name = request.name)
        val userTable: DynamoDbTable<User> = dynamoDbTable()
        println(newUser)
        userTable.putItem(newUser)
    }

    private fun dynamoDbTable(): DynamoDbTable<User> {
        val region = Region.US_EAST_1

        val dynamoDbClient = DynamoDbClient.builder()
            .region(region)
            .build()

        val dynamoDbClientEnhancedClient = DynamoDbEnhancedClient.builder()
            .dynamoDbClient(dynamoDbClient)
            .build()

        return dynamoDbClientEnhancedClient
            .table(tableName, TableSchema.fromBean(User::class.java))
    }
}