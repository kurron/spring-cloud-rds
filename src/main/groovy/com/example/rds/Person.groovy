package com.example.rds

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.Canonical
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Canonical
@Entity
class Person {
    @JsonProperty
    @Id
    @GeneratedValue
    private Long id

    @JsonProperty
    @Column(nullable = false)
    private String name

    // required by JPA
    Person() {}
}
