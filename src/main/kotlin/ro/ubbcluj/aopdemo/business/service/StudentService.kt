package ro.ubbcluj.aopdemo.business.service

import ro.ubbcluj.aopdemo.business.dto.StudentDto

interface StudentService {
    fun add(student: StudentDto): StudentDto

    fun update(student: StudentDto)

    fun deleteById(id: Long)

    fun findById(id: Long): StudentDto

    fun getAll(): List<StudentDto>
}