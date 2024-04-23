package org.example.carservice.service.impl

import org.example.carservice.dto.CarRequest
import org.example.carservice.dto.CarResponse
import org.example.carservice.dto.CarResponseList
import org.example.carservice.exception.CarNotFoundException
import org.example.carservice.mapper.CarExtension
import org.example.carservice.model.Car
import org.example.carservice.repository.CarRepository
import org.example.carservice.service.CarService
import org.example.carservice.util.ExceptionMessages
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CarServiceImpl(
    private val carRepository: CarRepository,
    private val carMapper : CarExtension) : CarService {
    override fun createCar(carRequest: CarRequest): CarResponse {
        val car = carMapper.fromRequestToEntity(carRequest)
        val savedCar = carRepository.save(car)
        return carMapper.fromEntityToResponse(savedCar)
    }

    private fun getOrThrow(id: Long): Car {
        return carRepository.findById(id)
            .orElseThrow { CarNotFoundException(String.format(ExceptionMessages.CAR_NOT_FOUND, id)) }
    }

    override fun findById(id: Long): CarResponse? {
        val car = getOrThrow(id)
        return carMapper.fromEntityToResponse(car)
    }

    override fun updateById(id: Long, request: CarRequest): CarResponse {
        val car = getOrThrow(id)
        val beforeUpdatedCar = carMapper.fromRequestToEntity(request)
        beforeUpdatedCar.id = car.id
        val updatedCar = carRepository.save(beforeUpdatedCar)
        return carMapper.fromEntityToResponse(updatedCar)

    }

    override fun deleteCarById(id: Long): CarResponse? {
        val car = getOrThrow(id)
        carRepository.delete(car)
        return carMapper.fromEntityToResponse(car)
    }

    override fun getAllCars(): CarResponseList? {
        val cars = carRepository.findAll()
        val carResponseList = cars
            .map { carMapper.fromEntityToResponse(it) }
        return CarResponseList(carResponseList)
    }

}
