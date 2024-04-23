package org.example.carservice.dto

data class CarResponse(
    private val id : Long,
    private val number: String,
    private val color: String,
    private val model: String,
    private val mark: String,
    ) {

}
