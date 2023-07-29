package com.example.jpa.persistence.repository

import com.example.jpa.persistence.entity.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface PersonRepository : JpaRepository<PersonEntity, Long> {
    fun findByCreatedAtBetweenOrderByName(startDate: LocalDateTime, endDate: LocalDateTime): List<PersonEntity>
    fun findByCreatedAtAfter(date: LocalDateTime): List<PersonEntity>
    // limit 1
    fun findFirstByNameAndSurnameIgnoreCase(name: String, surname: String): PersonEntity
    // limit 3
    fun findTop3ByNameAndSurnameIgnoreCase(name: String, surname: String): PersonEntity
    //fun findAllById() // getAllBy or queryAllBy or searchAllBy
    fun findAllByNameContainingIgnoreCase(name: String): List<PersonEntity>
    fun findAllByNameNotContainingIgnoreCase(name: String): List<PersonEntity>
    fun findAllByNameIn(names: List<String>): List<PersonEntity>
    fun countByName(name: String): Int

    //https://www.baeldung.com/spring-data-jpa-query
}