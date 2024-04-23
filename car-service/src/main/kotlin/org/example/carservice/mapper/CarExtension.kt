package org.example.carservice.mapper

import org.example.carservice.dto.CarRequest
import org.example.carservice.dto.CarResponse
import org.example.carservice.model.Car
import org.springframework.stereotype.Service

@Service
class CarExtension  {

    fun fromRequestToEntity(request:CarRequest) : Car {
        return Car(
            id=0,
            model = request.model,
            mark = request.mark,
            number = request.number,
            color = request.color

        )

    }

    fun fromEntityToResponse(car:Car) : CarResponse {
        return CarResponse(
            id=car.id,
            model = car.model,
            mark = car.mark,
            number = car.number,
            color = car.color

        )

    }
}