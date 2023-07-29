package com.example.jpa.persistence.entity

import com.example.jpa.dto.PersonalReference
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "person_reference")
data class PersonalReferenceEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "phone")
    val phone: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pers_id", referencedColumnName = "id", nullable = false)
    //https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
    @JsonBackReference
    val person: PersonEntity?

) {
    fun dtoToEntity(personalReference: PersonalReference) {
        personalReference.let {

        }
    }
}
