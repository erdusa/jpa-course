package com.example.jpa.dto

data class Faculty(
    val code: String,
    val name: String,
    val teachers: List<Long>
)
