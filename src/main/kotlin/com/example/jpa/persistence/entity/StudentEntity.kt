package com.example.jpa.persistence.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity
@Table(
    name = "student", schema = "public",
    uniqueConstraints = [UniqueConstraint(name = "code_uk", columnNames = ["code"])]
)
data class StudentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long?,

    // CascadeType.ALL allows to persist the data also in the person table
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "pers_id", referencedColumnName = "id")
    @JsonBackReference
    val person: PersonEntity,

    @Column(name = "code")
    val code: String,

    // revisar
//    @ManyToMany(cascade = [CascadeType.ALL], mappedBy = "students")
//    val subjects: List<Subject>
)
