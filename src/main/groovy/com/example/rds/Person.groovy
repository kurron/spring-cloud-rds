package com.example.rds

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Person {
    @Id
    @GeneratedValue
    private Long id

    @Column(nullable = false)
    private String name

    // required by JPA
    Person() {}
}
