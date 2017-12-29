package com.example.rds

import groovy.util.logging.Slf4j
import java.util.concurrent.ThreadLocalRandom
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
        Optional<Person> found = Optional.ofNullable( repository.findOne( id ) )
        found.orElse( new Person( id: 0, name: 'no such person' ) )
    }

    @PostMapping( path = '/person/{name}', produces = 'application/json' )
    Person addResource( @PathVariable( name = 'name' ) String name ) {
        log.info( 'Adding person {}', name )
        Person found = repository.save( construct( name ) )
        found
    }

    private static Person construct( String name ) {
        def account = new OnlineAccount( account: randomString(),
                                         username: randomString(),
                                         password: randomString() )
        new Person( name: name, account: account )
    }

    static String randomString() {
        Integer.toHexString( ThreadLocalRandom.current().nextInt( Integer.MAX_VALUE ) ).toUpperCase()
    }

    static void main( String[] args ) {
        SpringApplication.run Application, args
    }

}
