package com.example.jpa.persistence.repository

import com.example.jpa.persistence.entity.FacultyEntity
import org.springframework.data.jpa.repository.JpaRepository

interface FacultyRepository : JpaRepository<FacultyEntity, Long>