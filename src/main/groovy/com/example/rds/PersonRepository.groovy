package com.example.rds

import org.springframework.data.repository.Repository

interface PersonRepository extends Repository<Person, Long> {

}