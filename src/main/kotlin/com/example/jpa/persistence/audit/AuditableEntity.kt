package com.example.jpa.persistence.audit

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class AuditableEntity (

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private var createdAt: LocalDateTime? = null,

//    @CreatedBy
//    @Column(name = "created_by", updatable = false)
//    private var createdBy: String

    @LastModifiedDate
    @Column(name = "updated_at")
    private var updatedAt: LocalDateTime? = null

//    @LastModifiedBy
//    @Column(name = "updated_by")
//    private var updatedBy: String
)