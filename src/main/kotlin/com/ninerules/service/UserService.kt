package com.ninerules.service

import com.ninerules.model.NewUserRequest
import com.ninerules.model.User
import jakarta.inject.Singleton

@Singleton
class UserService {
    private val users = mutableListOf(
        User(1, "Manu", listOf())
    )

    fun getUsers() = users
    fun getUserInfoById(id: Int) = users.find { it.id == id }
    fun getUserInfoByName(name: String) = users.find { it.name == name }

    // data doesnt persist remember, so these new users will only exist as long as the server is running
    fun createUser(newUserRequest: NewUserRequest) = users.add(
        User(
            id = users.size + 1,
            name = newUserRequest.name,
            emptyList()
        )
    )
}