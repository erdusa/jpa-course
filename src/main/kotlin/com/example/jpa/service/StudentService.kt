package com.example.jpa.service

import com.example.jpa.dto.StudentCodeDto
import com.example.jpa.dto.UpdateStudentDto
import com.example.jpa.persistence.entity.StudentEntity
import com.example.jpa.persistence.repository.StudentRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StudentService(
    val studentRepository: StudentRepository
) {

    fun list(): List<StudentEntity> {
        return studentRepository.findAll()
    }

    fun list(page: Int, elements: Int): Page<StudentEntity> {
        val pageable = PageRequest.of(page, elements)
        return studentRepository.findAll(pageable)
    }

    fun listOrdered(page: Int, elements: Int, sortBy: String, sortDirection: String): Page<StudentEntity> {
        val sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy)
        val pageable = PageRequest.of(page, elements, sort)
        return studentRepository.findAll(pageable)
    }

    fun listWithSql(): List<StudentCodeDto> {
        return studentRepository.findStudentNameWithCode()
    }

    fun insert(personEntity: StudentEntity): StudentEntity {
        return studentRepository.save(personEntity)
    }

    fun delete(id: Long) {
        studentRepository.deleteById(id)
    }

    //@Transactional(noRollbackFor = [RuntimeException::class], propagation = Propagation.REQUIRED)
    //https://www.baeldung.com/spring-transactional-propagation-isolation
    @Transactional
    fun updateCode(updateStudentDto: UpdateStudentDto) {
        studentRepository.updateCodeStudent(updateStudentDto)
    }


}