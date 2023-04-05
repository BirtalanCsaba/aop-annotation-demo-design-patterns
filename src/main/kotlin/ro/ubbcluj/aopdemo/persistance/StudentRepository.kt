package ro.ubbcluj.aopdemo.persistance

import org.springframework.stereotype.Repository
import ro.ubbcluj.aopdemo.persistance.entity.Student

@Repository
interface StudentRepository: BaseRepository<Student, Long>