package com.example.jpa.persistence.repository

import com.example.jpa.persistence.entity.SubjectEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SubjectRepository : JpaRepository<SubjectEntity, Int>