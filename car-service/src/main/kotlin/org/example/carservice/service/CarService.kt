package org.example.carservice.service

import org.example.carservice.dto.CarRequest
import org.example.carservice.dto.CarResponse
import org.example.carservice.dto.CarResponseList

interface CarService {

    fun createCar(carRequest: CarRequest): CarResponse
    fun findById(id: Long): CarResponse?
    fun updateById(id: Long, request: CarRequest): CarResponse
    fun deleteCarById(id: Long): CarResponse?
    fun getAllCars(): CarResponseList?
}