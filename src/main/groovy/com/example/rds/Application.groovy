package com.example.rds

import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@Slf4j
@SpringBootApplication
@RestController
@EnableRdsInstance( dbInstanceIdentifier = 'sample', password = 'masterpassword' )
class Application {

    @GetMapping( path = '/echo/{id}' )
    String fetchResource( @PathVariable( name = 'id' ) String id ) {
        log.info( 'Handling request for {}', id )
        slowResource( id )
    }

    String slowResource( String key ) {
        log.info( 'Calculating expensive resource {}', key )
        Thread.sleep( 1000 * 4 )
        key.toUpperCase()
    }

    static void main( String[] args ) {
        SpringApplication.run Application, args
    }

}
