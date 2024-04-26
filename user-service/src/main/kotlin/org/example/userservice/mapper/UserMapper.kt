package org.example.userservice.mapper

import org.example.userservice.dto.UserRequest
import org.example.userservice.dto.UserResponse
import org.example.userservice.model.User
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun fromRequestToEntity(userRequest: UserRequest): User {
        return User(
            id = 0L,
            name = userRequest.name,
            email = userRequest.email,
            phone = userRequest.phone
        )
    }
    fun fromEntityToResponse(user: User): UserResponse {
        return UserResponse(
            id = user.id,
            name = user.name,
            email = user.email,
            phone = user.phone
        )
    }
}