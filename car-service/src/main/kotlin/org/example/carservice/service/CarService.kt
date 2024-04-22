package org.example.carservice.service

import org.example.carservice.dto.CarRequest
import org.example.carservice.dto.CarResponse
import org.example.carservice.repository.CarRepository
import org.springframework.stereotype.Service

@Service
class CarService(private val carRepository: CarRepository) {
    fun createCar(request: CarRequest): CarResponse? {

    }

}
