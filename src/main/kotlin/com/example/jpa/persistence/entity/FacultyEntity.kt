package com.example.jpa.persistence.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "faculty")
data class FacultyEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int? = null,

    @Column(name = "code")
    val code: String,

    @Column(name = "name")
    val name: String,

    // In this example we use @Join table for table teacher, we assume that that table only have 2 fields
    // pers_id one-to-one relation with person table
    // facu_id many-to-one with faculty table
    @OneToMany
    @JoinTable(
        name = "teacher",
        joinColumns = [JoinColumn(name = "facu_id")],
        inverseJoinColumns = [JoinColumn(name = "pers_id")]
    )
    val teachers: List<PersonEntity>
)
