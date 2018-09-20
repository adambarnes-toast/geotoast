package com.toasttab.geotoast

import com.toasttab.geotoast.model.Address
import com.toasttab.geotoast.model.PosOrder
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.PostConstruct

@Service
@Slf4j
class OrdersService {

    @Autowired OrdersRepository ordersRepository
    @Autowired AddressRepository addressRepository

    List<PosOrder> orders
    List<Address> addresses

    @PostConstruct
    void loadData(){
        log.info("Loading addresses")
        addresses = addressRepository.findAll()
        log.info("Loading orders")
        orders = ordersRepository.findAll()
    }

    PosOrder getLatest(){
        PosOrder order = getRandom(orders)
        order.address = getRandom(addresses)

        if (order.amount > 8 ){
            order.size = order.amount > 15 ? "L" : "M"
        }

        order.closed = new Date()
        order
    }

    public <T extends Object> T getRandom(List<T> list){
        list.get(new Random().nextInt(list.size()))
    }

}
