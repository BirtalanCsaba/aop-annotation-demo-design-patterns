package ro.ubbcluj.aopdemo.persistance

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.stereotype.Repository

@NoRepositoryBean
interface BaseRepository<E, ID>: JpaRepository<E, ID>