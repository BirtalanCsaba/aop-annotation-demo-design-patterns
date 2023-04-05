package ro.ubbcluj.aopdemo.persistance.entity

import jakarta.persistence.Entity
import java.time.LocalDate

@Entity
class Student: BaseEntity<Long> {
    var firstName: String? = null
    var lastName: String? = null
    var email: String? = null
    var dob: LocalDate? = null

    constructor()

    constructor(
        firstName: String?,
        lastName: String?,
        email: String?,
        dob: LocalDate?
    ) {
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
        this.dob = dob
    }
}