package com.example.rds

import org.springframework.data.repository.CrudRepository

interface PersonRepository extends CrudRepository<Person, Long> {

}