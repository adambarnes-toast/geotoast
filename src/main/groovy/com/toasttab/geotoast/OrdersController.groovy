package com.toasttab.geotoast

import com.toasttab.geotoast.model.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrdersController {

    @Autowired OrdersRepository ordersRepository

    @CrossOrigin
    @RequestMapping("/latest")
    public Order latest(){
        ordersRepository.getLatest()
    }

}
