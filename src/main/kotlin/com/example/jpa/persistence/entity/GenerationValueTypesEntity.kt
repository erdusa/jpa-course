package com.example.jpa.persistence.entity

//import javax.persistence.GeneratedValue
//import javax.persistence.GenerationType
import javax.persistence.Column
import javax.persistence.Id

//import javax.persistence.SequenceGenerator
//import javax.persistence.TableGenerator

//@Entity
//@Table(name = "USER")
data class GenerationValueTypesEntity(

    @Id
    @Column(name = "USER_ID")

//    // when database has autonumber types like serial in postgresql
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

//    // when database uses sequences
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
//    @SequenceGenerator(name = "user_seq", sequenceName = "USER_ID_SEQ", allocationSize = 1)

//    // when we use a table to manage the values for primary keys
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_table_generator")
//    @TableGenerator(
//        name = "user_table_generator", table = "FINANCES_KEYS", pkColumnName = "FINA_PK", valueColumnName = "FINA_VALUE"
//    )

//    // when we allow that JPA chooses the right generator depending on the database engine
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    // also it can be
//    @GeneratedValue

    val id: Long?
)
