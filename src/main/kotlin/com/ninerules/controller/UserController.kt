package com.ninerules.controller

import com.ninerules.model.NewUserRequest
import com.ninerules.service.UserService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post

@Controller("/users")
class UserController(private val userService: UserService) {

    @Get()
    fun getUsers() = userService.getUsers()

    // in kotlin you can pass in a param without naming it if it's the first expected param
    // uri is not, so it's gotta be named
    @Get(uri = "/{id}")
    fun userInfoById(@PathVariable id: String) = userService.getUserInfoById(id)

    @Get(uri = "/{name}")
    fun userInfoByName(@PathVariable name: String) = userService.getUserInfoByName(name)

    @Post()
    fun createUser(@Body newUserRequest: NewUserRequest) = userService.createUser(newUserRequest)
}
