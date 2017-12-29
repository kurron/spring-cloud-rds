package com.example.rds

import org.springframework.data.repository.CrudRepository

interface AddressRepository extends CrudRepository<Address, Long> {

}