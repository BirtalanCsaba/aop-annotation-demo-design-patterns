package ro.ubbcluj.aopdemo.business.modelmapper

import ro.ubbcluj.aopdemo.business.dto.BaseDto
import ro.ubbcluj.aopdemo.persistance.entity.BaseEntity
import java.io.Serializable

interface ModelMapper<E: BaseEntity<ID>, DTO: BaseDto<ID>, ID: Serializable> {
    fun entityToDto(entity: E): DTO

    fun dtoToEntity(dto: DTO): E
}