package com.toasttab.geotoast.model

import groovy.transform.EqualsAndHashCode

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Transient

@EqualsAndHashCode
@Entity
@Table(name="posOrders")
class PosOrder {

    @Id
    Long id

    @Transient
    Address address

    @Transient
    String size = 'S'

    Date closed

    Integer guests

    Double amount
}
