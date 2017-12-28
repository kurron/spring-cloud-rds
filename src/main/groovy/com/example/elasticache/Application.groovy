package com.example.elasticache

import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.Cacheable
import org.springframework.cloud.aws.cache.config.annotation.CacheClusterConfig
import org.springframework.cloud.aws.cache.config.annotation.EnableElastiCache
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@Slf4j
@SpringBootApplication
@RestController
@EnableElastiCache( @CacheClusterConfig( name= 'example-elasticache', expiration = 30 ) )
class Application {

    @GetMapping( path = '/echo/{id}' )
    String fetchResource( @PathVariable( name = 'id' ) String id ) {
        log.info( 'Handling request for {}', id )
        slowResource( id )
    }

    @Cacheable( 'SimpleCache' )
    String slowResource( String key ) {
        log.info( 'Calculating expensive resource {}', key )
        Thread.sleep( 1000 * 4 )
        key.toUpperCase()
    }

    static void main( String[] args ) {
        SpringApplication.run Application, args
    }
}
