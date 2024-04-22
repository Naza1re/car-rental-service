package org.example.carservice.controller

import org.example.carservice.dto.CarRequest
import org.example.carservice.dto.CarResponse
import org.example.carservice.service.CarService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/car")
class CarController(private val carService: CarService) {


    @PostMapping
    fun create(@RequestBody request: CarRequest): ResponseEntity<CarResponse> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(carService.createCar(request));
    }
}