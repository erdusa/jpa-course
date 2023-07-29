package com.example.jpa.persistence.repository

import com.example.jpa.persistence.entity.PersonEntity
import com.example.jpa.persistence.entity.embedeable.Address
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import java.time.LocalDateTime

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PersonRepositoryTest {

    @Autowired
    private lateinit var personRepository: PersonRepository

    @Autowired
    private lateinit var entityManager: TestEntityManager

    @Test
    fun `should save person when all data is sent it`() {
        // Arrange
        val address = Address(city = "city", neighborhood = "neighborhood")
        val newPersonEntity = PersonEntity(name = "success", surname = "good", address = address)

        // Act
        val personSaved = personRepository.save(newPersonEntity)

        // Assert
        val personQueried = entityManager.find(PersonEntity::class.java, personSaved.id)
        assertEquals(newPersonEntity, personQueried)
    }

    @Test
    fun `should update person when save is invoked`() {
        // Arrange
        val address = Address(city = "city", neighborhood = "neighborhood")
        val newPersonEntity = PersonEntity(name = "success", surname = "good", address = address)
        val insertedPerson = entityManager.persist(newPersonEntity)
        val newName = "updated"
        val updatePersonEntity = insertedPerson.copy(name = newName)

        // Act
        val personSaved = personRepository.save(updatePersonEntity)

        // Assert
        val personQueried = entityManager.find(PersonEntity::class.java, personSaved.id)
        assertEquals(newName, personQueried.name)
    }

    @Test
    fun `should find person when id is valid`() {
        // Arrange
        val address = Address(city = "city", neighborhood = "neighborhood")
        val newPersonEntity = PersonEntity(name = "success", surname = "good", address = address)
        val insertedPerson = entityManager.persist(newPersonEntity)

        // Act
        val personQueried = personRepository.findById(insertedPerson.id!!)

        // Assert
        assertEquals(insertedPerson, personQueried.get())
    }

    @Test
    fun `should findByCreatedAtAfter when data is ok`() {
        // Arrange
        val address = Address(city = "city", neighborhood = "neighborhood")
        val newPersonEntity1 = PersonEntity(name = "success", surname = "good", address = address)
        entityManager.persist(newPersonEntity1)

        val currentDateTime = LocalDateTime.now()
        val newPersonEntity2 = PersonEntity(name = "success", surname = "good", address = address)
        entityManager.persist(newPersonEntity2)
        val newPersonEntity3 = PersonEntity(name = "success", surname = "good", address = address)
        entityManager.persist(newPersonEntity3)

        // Act
        val result = personRepository.findByCreatedAtAfter(currentDateTime)

        // Assert
        assertEquals(2, result.size)
    }

    @Test
    fun `should delete person when id is valid`() {
        // Arrange
        val address = Address(city = "city", neighborhood = "neighborhood")
        val newPersonEntity = PersonEntity(name = "success", surname = "good", address = address)
        val insertedPerson = entityManager.persist(newPersonEntity)

        // Act
        personRepository.deleteById(insertedPerson.id!!)

        // Assert
        val personQueried = entityManager.find(PersonEntity::class.java, insertedPerson.id)
        assertNotNull(insertedPerson.id)
        assertNull(personQueried)
    }
}