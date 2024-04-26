package org.example.userservice.exception.handler

import org.example.userservice.exception.UserNotFoundException
import org.example.userservice.exception.appError.AppError
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(e: RuntimeException): ResponseEntity<AppError> {
        val errorMessage = e.localizedMessage
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(AppError(errorMessage))

    }
}