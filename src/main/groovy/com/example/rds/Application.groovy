package com.example.rds

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@SpringBootApplication
@RestController
@EnableRdsInstance( dbInstanceIdentifier = 'sample', password = 'masterpassword' )
class Application {

    @Autowired
    PersonRepository repository

    @GetMapping( path = '/person/{id}', produces = 'application/json' )
    Person fetchResource( @PathVariable( name = 'id' ) Long id ) {
        log.info( 'Searching for person {}', id )
        Person found = repository.findOne( id )
        found
    }

    @PostMapping( path = '/person/{name}', produces = 'application/json' )
    Person addResource( @PathVariable( name = 'name' ) String name ) {
        log.info( 'Adding person {}', name )
        Person found = repository.save( new Person( name: name ) )
        found
    }

    static void main( String[] args ) {
        SpringApplication.run Application, args
    }

}
