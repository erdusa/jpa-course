package com.example.jpa.persistence.entity

import com.example.jpa.persistence.audit.AuditPersonListener
import com.example.jpa.persistence.audit.AuditableEntity
import com.example.jpa.persistence.entity.embedeable.Address
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.hibernate.annotations.Formula
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.CascadeType
import javax.persistence.CollectionTable
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.MapKeyColumn
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.OrderBy
import javax.persistence.Table

@Entity
@Table(name = "person")
@EntityListeners(AuditingEntityListener::class, AuditPersonListener::class)
data class PersonEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "name", length = 150)
    var name: String,

    @Column(name = "second_name", nullable = true)
    val secondName: String? = null,

    @Column(name = "surname")
    val surname: String,

    @Formula("name || ' ' || coalesce(second_name,'') || ' ' || surname")
    val wholeName: String? = null,

    @Embedded
    val address: Address,

    @ElementCollection
    @CollectionTable(name = "friend", joinColumns = [JoinColumn(name = "pers_id", referencedColumnName = "id")])
    @Column(name = "name", nullable = true)
    val friends: List<String>? = null,

    @ElementCollection
    @CollectionTable(name = "hobby", joinColumns = [JoinColumn(name = "pers_id", referencedColumnName = "id")])
    @MapKeyColumn(name = "position")
    @Column(name = "name", nullable = true)
    val hobbies: Map<Byte, String>? = null,

    // this is not necessary for one to one
    // the @OneToOne in the another table is what is important
    @OneToOne(mappedBy = "person")
    @JsonManagedReference
    val studentEntity: StudentEntity? = null,

    // For OneToMany and ManyToMany by default fetch is LAZY
    // For ManyToOne and OneToOne by default fetch is EAGER
    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "person", fetch = FetchType.LAZY)
    @JsonManagedReference
    @OrderBy("name ASC")
    var references: List<PersonalReferenceEntity> = ArrayList()

): AuditableEntity() {
    // @Transient //it is necessary in java to mark the attribute as it is not belong to the table
    val hasSecondName: Boolean
        get() = secondName.isNullOrBlank().not()
}

