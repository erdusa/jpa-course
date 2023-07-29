package com.example.jpa.persistence.entity.primary

import java.io.Serializable

data class StudentSemesterId(
    val studentId: Long,
    val numberSemester: Int
): Serializable