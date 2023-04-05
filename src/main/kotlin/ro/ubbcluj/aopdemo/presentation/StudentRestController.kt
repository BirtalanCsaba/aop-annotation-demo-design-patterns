package ro.ubbcluj.aopdemo.presentation

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ro.ubbcluj.aopdemo.business.dto.StudentDto
import ro.ubbcluj.aopdemo.business.service.StudentService

@RestController
@RequestMapping("/students")
class StudentRestController(
    val studentService: StudentService
) {
    @GetMapping
    fun getAll(): ResponseEntity<List<StudentDto>> {
        return ResponseEntity.ok(studentService.getAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<StudentDto> {
        return ResponseEntity.ok(studentService.findById(id))
    }

    @PostMapping
    fun save(@RequestBody student: StudentDto): ResponseEntity<StudentDto> {
        return ResponseEntity.ok(studentService.add(student))
    }

    @DeleteMapping("/{id}")
    fun removeById(@PathVariable id: Long): ResponseEntity<*> {
        studentService.deleteById(id)
        return ResponseEntity.status(HttpStatus.OK).body("Entity deleted")
    }

    @PutMapping
    fun update(@RequestBody student: StudentDto): ResponseEntity<*> {
        studentService.update(student)
        return ResponseEntity.status(HttpStatus.OK).body("Entity updated")
    }

}