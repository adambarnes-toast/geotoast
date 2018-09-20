package com.toasttab.geotoast

import com.toasttab.geotoast.model.Address
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository extends JpaRepository<Address, Long>{

}
