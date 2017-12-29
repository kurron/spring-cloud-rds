package com.example.rds

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.Canonical
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Canonical
@Entity
class Person {
    @JsonProperty
    @Id
    @GeneratedValue
    private Long id

    @JsonProperty
    @Column( nullable = false )
    private String name

    @JsonProperty
    @ElementCollection
    private List<OnlineAccount> accounts = new ArrayList<>( 32 )

    @JsonProperty
    @OneToMany( mappedBy = 'person' )
    private List<Address> addresses = new ArrayList<>( 32 )

    // required by JPA
    Person() {}
}
