package com.example.jpa.service

import com.example.jpa.dto.Faculty
import com.example.jpa.persistence.entity.FacultyEntity
import com.example.jpa.persistence.repository.FacultyRepository
import com.example.jpa.persistence.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class FacultyService(
    val facultyRepository: FacultyRepository,
    val personRepository: PersonRepository
) {

    fun list(): List<FacultyEntity> {
        return facultyRepository.findAll()
    }

    fun insert(faculty: Faculty): FacultyEntity {
        return facultyRepository.save(faculty.dtoTOEntity())
    }

    fun delete(id: Long) {
        facultyRepository.deleteById(id)
    }

    fun Faculty.dtoTOEntity() =
        FacultyEntity(
            code = this.code,
            name = this.name,
            teachers = this.teachers.map {
                personRepository.findById(it).orElseThrow { IllegalArgumentException("Not exist person with id $it") }
            }
        )
}
