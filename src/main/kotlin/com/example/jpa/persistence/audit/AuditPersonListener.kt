package com.example.jpa.persistence.audit

import com.example.jpa.persistence.entity.PersonEntity
import javax.persistence.PostLoad
import javax.persistence.PostPersist
import javax.persistence.PostUpdate
import javax.persistence.PreRemove
import javax.persistence.PreUpdate

class AuditPersonListener {

    private lateinit var currentEntity: PersonEntity

    @PostLoad
    fun onPostLoad(entity: PersonEntity) {
        println("POST LOAD $entity")
    }

    @PostPersist
    fun onPostPersist(entity: PersonEntity) {
        println("NEW VALUE: $entity")
    }

    @PreUpdate
    fun onPreUpdate(entity: PersonEntity) {
        currentEntity = entity.copy()
    }

    @PostUpdate
    fun onPostUpdate(entity: PersonEntity) {
        println("POST UPDATE")
        println("OLD VALUE: $currentEntity")
        println("NEW VALUE: $entity")
    }

    @PreRemove
    fun onPreDelete(entity: PersonEntity) {
        println(entity)
    }
}