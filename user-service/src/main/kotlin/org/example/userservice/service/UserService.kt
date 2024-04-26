package org.example.userservice.service

import org.example.userservice.dto.UserRequest
import org.example.userservice.dto.UserResponse

interface UserService {
    fun createUser(request: UserRequest): UserResponse?
    fun getUserById(id: Long): UserResponse?
    fun deleteUser(id: Long): UserResponse?
    fun updateUser(id: Long, userRequest: UserRequest): UserResponse?

}
