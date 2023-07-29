package com.example.jpa.controller

import com.example.jpa.dto.StudentCodeDto
import com.example.jpa.dto.UpdateStudentDto
import com.example.jpa.persistence.entity.StudentEntity
import com.example.jpa.service.StudentService
import org.springframework.data.domain.Page
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/student"])
class StudentController(
    val studentService: StudentService
) {

    @GetMapping
    fun getAll(): List<StudentEntity> {
        return studentService.list()
    }

    @GetMapping("/page")
    fun getAll(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") elements: Int
    ): Page<StudentEntity> {
        return studentService.list(page, elements)
    }

    @GetMapping("/page/order")
    fun getAll(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") elements: Int,
        @RequestParam(defaultValue = "code") sortBy: String,
        @RequestParam(defaultValue = "ASC") sortDirection: String,
    ): Page<StudentEntity> {
        return studentService.listOrdered(page, elements, sortBy, sortDirection)
    }

    @GetMapping("/sql")
    fun getWithSql(): ResponseEntity<List<StudentCodeDto>> {
        return ResponseEntity.ok(studentService.listWithSql())
    }

    @PostMapping
    fun add(
        @RequestBody request: StudentEntity
    ): StudentEntity {
        return studentService.insert(request)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @PathVariable("id") id: Long
    ) {
        studentService.delete(id)
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCode(
        @RequestBody updateStudentDto: UpdateStudentDto
    ): ResponseEntity<Unit> {
        return ResponseEntity.ok(studentService.updateCode(updateStudentDto))
    }

}