package com.example.jpa.dto

import com.example.jpa.persistence.entity.embedeable.Address

data class Person(
    val id: Long?,
    val name: String,
    val surname: String,
    val address: Address,
    val references: List<PersonalReference> = ArrayList()
)

