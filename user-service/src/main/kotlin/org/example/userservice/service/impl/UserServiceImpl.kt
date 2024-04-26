package org.example.userservice.service.impl

import org.example.userservice.dto.UserRequest
import org.example.userservice.dto.UserResponse
import org.example.userservice.exception.UserNotFoundException
import org.example.userservice.mapper.UserMapper
import org.example.userservice.model.User
import org.example.userservice.repository.UserRepository
import org.example.userservice.service.UserService
import org.example.userservice.util.ExceptionMessages
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val userRepository: UserRepository,
    val userMapper: UserMapper
) : UserService {
    override fun createUser(request: UserRequest): UserResponse? {
        val user = userMapper.fromRequestToEntity(request)
        val savedUser = userRepository.save(user)
        return userMapper.fromEntityToResponse(savedUser)
    }

    private fun getOrThrow(id: Long): User {
        return userRepository.findById(id)
            .orElseThrow { UserNotFoundException(String.format(ExceptionMessages.USER_NOT_FOUND, id)) }
    }

    override fun getUserById(id: Long): UserResponse? {
        val user = getOrThrow(id)
        return userMapper.fromEntityToResponse(user)
    }

    override fun deleteUser(id: Long): UserResponse? {
        val user = getOrThrow(id)
        userRepository.delete(user)
        return userMapper.fromEntityToResponse(user)
    }

    override fun updateUser(id: Long, userRequest: UserRequest): UserResponse? {
        val user = getOrThrow(id)
        val newUser = userMapper.fromRequestToEntity(userRequest)
        newUser.id = user.id
        return userMapper.fromEntityToResponse(newUser)
    }
}