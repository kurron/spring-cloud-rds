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
    PersonRepository personRepository

    @Autowired
    AddressRepository addressRepository

    @GetMapping( path = '/person/{id}', produces = 'application/json' )
    Person fetchPerson( @PathVariable( name = 'id' ) Long id ) {
        log.info( 'Searching for person {}', id )
        Optional<Person> found = Optional.ofNullable( personRepository.findOne( id ) )
        found.orElse( new Person( id: 0, name: 'no such person' ) )
    }

    @PostMapping( path = '/person/{name}', produces = 'application/json' )
    Person addResource( @PathVariable( name = 'name' ) String name ) {
        log.info( 'Adding person {}', name )
        Person stored = personRepository.save( construct( name ) )
        construct( stored )
        stored
    }

    @GetMapping( path = '/address/{id}', produces = 'application/json' )
    Address fetchAdress( @PathVariable( name = 'id' ) Long id ) {
        log.info( 'Searching for address {}', id )
        Optional<Address> found = Optional.ofNullable( addressRepository.findOne( id ) )
        found.orElse( new Address( id: 0, street: 'no such address', zipcode: 0 ) )
    }

    private List<Address> construct( Person person ) {
        def addresses = (1..2).collect {
            new Address( person: person, street: randomString(), zipcode: randomNumber() )
        }
        List<Address> associated = personRepository.save( addresses ).toList()
        associated
    }

    private static Person construct( String name ) {
        def accounts = (1..4).collect {
            new OnlineAccount( account: randomString(),
                               username: randomString(),
                               password: randomString() )
        }

        new Person( name: name, accounts: accounts )
    }

    static String randomString() {
        Integer.toHexString( ThreadLocalRandom.current().nextInt( Integer.MAX_VALUE ) ).toUpperCase()
    }

    static int randomNumber() {
        ThreadLocalRandom.current().nextInt( Integer.MAX_VALUE )
    }
    static void main( String[] args ) {
        SpringApplication.run Application, args
    }

}
