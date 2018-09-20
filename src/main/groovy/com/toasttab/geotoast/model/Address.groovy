package com.toasttab.geotoast.model

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Address {

    Long id
    String name
    String city
    String state
    String zip
    Double latitude
    Double longitude


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
