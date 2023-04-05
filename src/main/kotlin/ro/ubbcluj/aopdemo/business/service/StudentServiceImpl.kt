package ro.ubbcluj.aopdemo.business.service

import jakarta.transaction.Transactional
import org.slf4j.LoggerFactory
import org.springframework.dao.DataAccessException
import org.springframework.stereotype.Service
import ro.ubbcluj.aopdemo.business.dto.StudentDto
import ro.ubbcluj.aopdemo.business.modelmapper.StudentModelMapper
import ro.ubbcluj.aopdemo.business.service.exception.ServiceException
import ro.ubbcluj.aopdemo.persistance.StudentRepository

@Service
class StudentServiceImpl (
    val studentRepository: StudentRepository,
    val studentModelMapper: StudentModelMapper
) : StudentService {
    val logger = LoggerFactory.getLogger(StudentService::class.java)

    override fun add(student: StudentDto): StudentDto {
        val studentEntity = studentModelMapper.dtoToEntity(student)
        try {
            val createdEntity = studentRepository.save(studentEntity)
            return studentModelMapper.entityToDto(createdEntity)
        } catch (e: DataAccessException) {
            logger.error(e.message)
            logger.error(e.stackTraceToString())
            throw ServiceException("Repository exception")
        }
    }

    @Transactional
    override fun update(student: StudentDto) {
        studentModelMapper.dtoToEntity(student)
        if (student.id == null) {
            throw ServiceException("Null id supplied")
        }
        try {
            studentRepository.findById(student.id!!).ifPresent {
                it.firstName = student.firstName
                it.lastName = student.lastName
                it.email = student.email
                it.dob = student.dob
            }
        } catch (e: DataAccessException) {
            logger.error(e.message)
            logger.error(e.stackTraceToString())
            throw ServiceException("Repository exception")
        }

    }

    override fun deleteById(id: Long) {
        studentRepository.deleteById(id)
    }

    override fun findById(id: Long): StudentDto {
        val result = studentRepository.findById(id)
            .orElseThrow {
                ServiceException("Student not found")
            }
        return studentModelMapper.entityToDto(result)
    }

    override fun getAll(): List<StudentDto> {
        val resultList = studentRepository.findAll()
        val convertedResultList = ArrayList<StudentDto>()
        for (elem in resultList) {
            convertedResultList.add(studentModelMapper.entityToDto(elem))
        }
        return convertedResultList
    }


}