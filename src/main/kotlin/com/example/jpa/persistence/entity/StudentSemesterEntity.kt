package com.example.jpa.persistence.entity

import com.example.jpa.persistence.entity.primary.StudentSemesterId
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ForeignKey
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "student_semester")
@IdClass(StudentSemesterId::class)
class StudentSemesterEntity(
    @Id
    @Column(name = "stud_id")
    val studentId: Long,

    @Id
    @Column(name = "number_semester")
    val numberSemester: Int,

    @Column(nullable = false, precision = 2, scale = 2)
    val average: Float,

    @ManyToOne()
    // insertable = false, updatable = false don't allow to insert or update student from here
    @JoinColumn(name = "stud_id", referencedColumnName = "id", insertable = false, updatable = false,
        foreignKey = ForeignKey(name = "fk_stse_stud")
    )
    val student: StudentEntity

)