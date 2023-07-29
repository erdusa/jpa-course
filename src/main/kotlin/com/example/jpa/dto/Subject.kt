package com.example.jpa.dto

data class Subject(
    val code: String,
    val name: String,
    val students: List<Long>
)
