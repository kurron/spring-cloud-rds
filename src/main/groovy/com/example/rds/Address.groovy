package com.example.rds

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.Canonical
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

/**
 * A standalone entity with an lifecycle of its "parent".
 */
@Canonical
@Entity
class Address {
    @JsonProperty
    @Id
    @GeneratedValue
    private Long id

    @JsonProperty
    @Column(nullable = false)
    private String street

    @JsonProperty
    @Column(nullable = false)
    private Integer zipcode

    @JsonProperty
    @ManyToOne( optional = false )
    private Person person

    // required by JPA
    Address() {}
}
