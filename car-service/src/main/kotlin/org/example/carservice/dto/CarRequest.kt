package org.example.carservice.dto

data class CarRequest(
     val id : Long,
     val number: String,
     val color: String,
     val model: String,
     val mark: String
) {

}
