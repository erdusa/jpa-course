package com.example.jpa.controller

import com.example.jpa.dto.Subject
import com.example.jpa.persistence.entity.SubjectEntity
import com.example.jpa.service.SubjectService
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
@RequestMapping(value = ["/subject"])
class SubjectController(
    val subjectService: SubjectService
) {

    @GetMapping
    fun getAll(): List<SubjectEntity> {
        return subjectService.list()
    }

    @PostMapping
    fun add(
        @RequestBody request: Subject
    ): SubjectEntity? {
        return subjectService.insert(request)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @PathVariable("id") id: Int
    ) {
        subjectService.delete(id)
    }

}