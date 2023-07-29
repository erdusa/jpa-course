package com.example.jpa.controller

import com.example.jpa.dto.Faculty
import com.example.jpa.persistence.entity.FacultyEntity
import com.example.jpa.service.FacultyService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/faculty"])
class FacultyController(
    val facultyService: FacultyService
) {

    @GetMapping
    fun getAll(): List<FacultyEntity> {
        return facultyService.list()
    }

    @PostMapping
    fun add(
        @RequestBody request: Faculty
    ): FacultyEntity? {
        return facultyService.insert(request)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @PathVariable("id") id: Long
    ) {
        facultyService.delete(id)
    }

}