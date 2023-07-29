package com.example.jpa.service

import com.example.jpa.dto.Person
import com.example.jpa.persistence.entity.PersonEntity
import com.example.jpa.persistence.entity.PersonalReferenceEntity
import com.example.jpa.persistence.repository.PersonRepository
import org.springframework.data.domain.Sort
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PersonService(
    val personRepository: PersonRepository,
    val jdbcTemplate: JdbcTemplate
) {

    fun list(): List<PersonEntity> {
        val sort = Sort.by(Sort.Order.asc("name"))
            .and(Sort.by(Sort.Order.asc("secondName").ignoreCase().nullsFirst()))
            .and(Sort.by(Sort.Order.asc("surname").ignoreCase()))
        return personRepository.findAll(sort)
    }

    fun getAll(): List<PersonEntity> {
        return jdbcTemplate.query("select * from person", BeanPropertyRowMapper(PersonEntity::class.java))
    }

    fun insert(person: Person): PersonEntity {
        return personRepository.save(person.dtoToEntity())
    }

    fun delete(id: Long) {
        personRepository.deleteById(id)
    }

    fun getBetweenCreatedDate(startDate: LocalDateTime, endDate: LocalDateTime): List<PersonEntity> {
        return personRepository.findByCreatedAtBetweenOrderByName(startDate, endDate)
    }

    private fun Person.dtoToEntity(): PersonEntity {
        val personEntity = PersonEntity(id = this.id, name = this.name, surname = this.surname, address = this.address)
        personEntity.references = this.references.map {
            PersonalReferenceEntity(name = it.name, phone = it.phone, person = personEntity)
        }
        return personEntity
    }


}