package ro.ubbcluj.aopdemo.persistance.entity

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import java.io.Serializable

@MappedSuperclass
abstract class BaseEntity<ID: Serializable> {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    var id: ID? = null
}