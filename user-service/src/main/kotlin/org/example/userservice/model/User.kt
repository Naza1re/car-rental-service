package org.example.userservice.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class User(@Id var id: Long, val name: String, val email: String, val phone:String){


}