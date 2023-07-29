package com.example.jpa.persistence.repository

import com.example.jpa.persistence.entity.StudentSemesterEntity
import org.springframework.data.jpa.repository.JpaRepository

interface StudentSemesterRepository : JpaRepository<StudentSemesterEntity, Int> {
    fun findAllByAverageGreaterThanEqualOrderByAverageDesc(average: Float): List<StudentSemesterEntity>
}