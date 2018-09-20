package com.toasttab.geotoast.model

import groovy.transform.EqualsAndHashCode

import javax.persistence.Entity
import javax.persistence.Id

@EqualsAndHashCode
@Entity
class Address {

    @Id
    Long id
    String name
    String city
    String state
    String zip
    Double latitude
    Double longitude

    Address(){}

    Address(Long id, String name, String city, String state, String zip, Double latitude, Double longitude) {
        this.id = id
        this.name = name
        this.city = city
        this.state = state
        this.zip = zip
        this.latitude = latitude
        this.longitude = longitude
    }
}
