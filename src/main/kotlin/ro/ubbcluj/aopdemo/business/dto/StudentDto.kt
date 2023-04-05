package ro.ubbcluj.aopdemo.business.dto

import java.time.LocalDate

class StudentDto: BaseDto<Long> {
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