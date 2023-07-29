package com.example.jpa.persistence.repository

import com.example.jpa.dto.StudentCodeDto
import com.example.jpa.dto.UpdateStudentDto
import com.example.jpa.persistence.entity.StudentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.query.Procedure
import org.springframework.data.repository.query.Param

interface StudentRepository : JpaRepository<StudentEntity, Long> {

    @Query("SELECT s FROM StudentEntity s WHERE s.code = :code")
    fun getByCode(@Param(value = "code") code: String)

    @Query(
        "select p.name as nombre, p.surname as apellido , s.code as codigo from person p inner join student s on p.id = s.pers_id", nativeQuery = true
    )
    fun findStudentNameWithCode(): List<StudentCodeDto>

    @Query(
        "update student set code = :#{#student.code} where id = :#{#student.id}",
        nativeQuery = true
    )
    @Modifying
    fun updateCodeStudent(@Param("student") updateStudentDto: UpdateStudentDto)

    @Procedure(value = "procedure_name", outputParameterName = "parameter_name")
    fun executeProcedure(@Param("person_id") personId: String): Boolean
}