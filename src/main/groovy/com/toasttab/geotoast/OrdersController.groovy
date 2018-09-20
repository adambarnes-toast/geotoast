package com.toasttab.geotoast

import com.toasttab.geotoast.model.PosOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrdersController {

    @Autowired OrdersService ordersService

    @CrossOrigin
    @RequestMapping("/latest")
    public PosOrder latest(){
        ordersService.getLatest()
    }

}
