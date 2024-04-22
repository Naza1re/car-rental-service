package org.example.carservice.model

import jakarta.persistence.*


@Entity
@Table(name = "car")
class Car(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long,
    val number: String,
    val color: String,
    val model: String,
    val mark: String) {


}