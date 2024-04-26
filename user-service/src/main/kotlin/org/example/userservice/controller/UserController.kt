package org.example.userservice.controller

import org.example.userservice.dto.UserRequest
import org.example.userservice.dto.UserResponse
import org.example.userservice.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/user")
class UserController(val userService: UserService) {

    @PostMapping()
    fun createUser(request: UserRequest): ResponseEntity<UserResponse> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(userService.createUser(request))
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(userService.getUserById(id))
    }

    @DeleteMapping("/{id}")
    fun deleteUserById(@PathVariable id: Long): ResponseEntity<UserResponse> {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body(userService.deleteUser(id))
    }

    @PutMapping("/{id}")
    fun updateUserById(@PathVariable id: Long, @RequestBody userRequest: UserRequest): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(userService.updateUser(id, userRequest))
    }
}