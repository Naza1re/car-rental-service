package org.example.userservice.service

import org.example.userservice.dto.UserRequest
import org.example.userservice.dto.UserResponse

interface UserService {
    fun createUser(request: UserRequest): UserResponse?

}
