package org.example.userservice.service.impl

import org.example.userservice.dto.UserRequest
import org.example.userservice.dto.UserResponse
import org.example.userservice.mapper.UserMapper
import org.example.userservice.repository.UserRepository
import org.example.userservice.service.UserService
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
}