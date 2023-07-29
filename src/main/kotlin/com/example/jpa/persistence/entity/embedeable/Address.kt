package com.example.jpa.persistence.entity.embedeable

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class Address(

    @Column(name = "city")
    val city: String,

    @Column(name = "neighborhood")
    val neighborhood: String

)
