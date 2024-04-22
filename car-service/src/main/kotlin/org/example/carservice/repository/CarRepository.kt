package org.example.carservice.repository

import org.example.carservice.model.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface CarRepository : JpaRepository<Car, Long> {

}
