package com.example.rds

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.Canonical
import javax.persistence.Column
import javax.persistence.Embeddable

@Canonical
@Embeddable
class OnlineAccount {

    @JsonProperty
    @Column(nullable = false)
    private String account

    @JsonProperty
    @Column(nullable = false)
    private String username

    @JsonProperty
    @Column(nullable = false)
    private String password

    // JPA requires this
    OnlineAccount() {}
}
