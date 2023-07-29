package com.example.jpa.persistence.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "subject")
data class SubjectEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int? = null,

    @Column(name = "code")
    val code: String,

    @Column(name = "name")
    val name: String,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "subject_student", joinColumns = [JoinColumn(name="subj_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "stud_id", referencedColumnName = "id")])
    @JsonManagedReference
    val students: List<StudentEntity>
)
