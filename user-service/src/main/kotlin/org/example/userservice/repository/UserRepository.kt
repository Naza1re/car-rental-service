package org.example.userservice.repository

import org.example.userservice.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

}
