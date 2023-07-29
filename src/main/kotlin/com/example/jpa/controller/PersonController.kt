package com.example.jpa.controller

import com.example.jpa.dto.Person
import com.example.jpa.persistence.entity.PersonEntity
import com.example.jpa.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit

@RestController
@RequestMapping(value = ["/person"])
class PersonController(
    val personService: PersonService
) {

    @GetMapping
    fun list(): List<PersonEntity> {
        return personService.list()
    }

    @GetMapping("/all")
    fun getAll(): ResponseEntity<List<PersonEntity>> {
        return ResponseEntity.ok(personService.list())
    }

    @PostMapping
    fun add(
        @RequestBody request: Person
    ): PersonEntity? {
        return personService.insert(request)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @PathVariable("id") id: Long
    ) {
        personService.delete(id)
    }

    @GetMapping("/created-date")
    fun getBetweenCreatedDate(
        @RequestHeader(name = "start_date") startDateStr: String,
        @RequestHeader(name = "end_date") endDateStr: String
    ): List<PersonEntity> {
        val dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val startDate = LocalDate.parse(startDateStr, dateTimeFormatter).atStartOfDay()
        val endDate = LocalDate.parse(endDateStr, dateTimeFormatter).atTime(LocalTime.MAX)
        println("endDate $endDate")
        return personService.getBetweenCreatedDate(startDate, endDate)
    }

}