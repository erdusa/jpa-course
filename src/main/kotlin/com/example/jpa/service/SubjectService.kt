package com.example.jpa.service

import com.example.jpa.dto.Subject
import com.example.jpa.persistence.entity.FacultyEntity
import com.example.jpa.persistence.entity.SubjectEntity
import com.example.jpa.persistence.repository.StudentRepository
import com.example.jpa.persistence.repository.SubjectRepository
import org.springframework.stereotype.Service

@Service
class SubjectService(
    val subjectRepository: SubjectRepository,
    val studentRepository: StudentRepository
) {

    fun list(): List<SubjectEntity> {
        return subjectRepository.findAll()
    }

    fun insert(subject: Subject): SubjectEntity {
        return subjectRepository.save(subject.dtoTOEntity())
    }

    fun delete(id: Int) {
        subjectRepository.deleteById(id)
    }

    fun Subject.dtoTOEntity() =
        SubjectEntity(
            code = this.code,
            name = this.name,
            students = this.students.map {
                studentRepository.findById(it).orElseThrow { IllegalArgumentException("Not exist student with id $it") }
            }
        )
}
