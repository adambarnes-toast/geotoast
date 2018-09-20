package com.toasttab.geotoast.model

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Order {

    Long id
    Address address
    Date closedDate
    Integer numberOfGuests
    BigDecimal amount
}
