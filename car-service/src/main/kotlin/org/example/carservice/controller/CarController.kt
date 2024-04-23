package org.example.carservice.controller

import org.example.carservice.dto.CarRequest
import org.example.carservice.dto.CarResponse
import org.example.carservice.dto.CarResponseList
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

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CarResponse> {
        return ResponseEntity.ok(carService.findById(id));
    }

    @PutMapping("/{id}")
    fun updateById(@PathVariable id: Long, @RequestBody request: CarRequest): ResponseEntity<CarResponse> {
        return ResponseEntity.ok(carService.updateById(id, request))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<CarResponse> {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body(carService.deleteCarById(id))
    }

    @GetMapping
    fun list(): ResponseEntity<CarResponseList> {
        return ResponseEntity.ok(carService.getAllCars())
    }
}