package ro.ubbcluj.aopdemo.business.modelmapper

import org.springframework.stereotype.Component
import ro.ubbcluj.aopdemo.business.dto.StudentDto
import ro.ubbcluj.aopdemo.persistance.entity.Student

@Component
class StudentModelMapper: ModelMapper<Student, StudentDto, Long> {
    override fun entityToDto(entity: Student): StudentDto {
        val result = StudentDto(
            entity.firstName,
            entity.lastName,
            entity.email,
            entity.dob
        )
        result.id = entity.id
        return result
    }

    override fun dtoToEntity(dto: StudentDto): Student {
        val result = Student(
            dto.firstName,
            dto.lastName,
            dto.email,
            dto.dob
        )
        result.id = dto.id
        return result
    }
}