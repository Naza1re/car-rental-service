package org.example.userservice.controller

import org.example.userservice.dto.UserRequest
import org.example.userservice.dto.UserResponse
import org.example.userservice.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class UserController(val userService: UserService) {

    @PostMapping()
    fun createUser(request: UserRequest): ResponseEntity<UserResponse> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(userService.createUser(request))
    }
}