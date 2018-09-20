package com.toasttab.geotoast

import com.toasttab.geotoast.model.PosOrder
import org.springframework.data.jpa.repository.JpaRepository

interface OrdersRepository extends JpaRepository<PosOrder, Long>{

}
