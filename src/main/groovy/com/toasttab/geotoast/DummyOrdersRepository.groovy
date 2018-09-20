package com.toasttab.geotoast

import com.toasttab.geotoast.model.Address
import com.toasttab.geotoast.model.PosOrder
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

@Component
class DummyOrdersRepository {

    List<PosOrder> orders = []
    List<Address> addresses = []

    int count=0

    @PostConstruct
    void initData(){
        orders.add(new PosOrder(amount: 8.99, guests: 1))
        orders.add(new PosOrder(amount: 6.05, guests: 4))
        orders.add(new PosOrder(amount: 5.50, guests: 1))
        orders.add(new PosOrder(amount: 50, guests: 2))
        orders.add(new PosOrder(amount: 0.49, guests: 1))
        orders.add(new PosOrder(amount: 35.11, guests: 1))
        orders.add(new PosOrder(amount: 32, guests: 2))
        orders.add(new PosOrder(amount: 26.35, guests: 2))
        orders.add(new PosOrder(amount: 10.71, guests: 1))
        orders.add(new PosOrder(amount: 10, guests: 3))

        addresses.add(new Address(5955l,"Eli's Prime SteakHouse","NewYork","NY","10001",40.75386109999999,-73.9959466))
        addresses.add(new Address(6346,"Barismo","Arlington","MA","02474",42.4052847,-71.1416278))
        addresses.add(new Address(171592,"Madrona Tree","Arlington","MA","02474",42.4144092,-71.1505727))
        addresses.add(new Address(40907,"Finale Desserts","Cambridge","MA","02138",42.37244680000001,-71.119202))
        addresses.add(new Address(2660,"Shanghai Restaurant","Bristol","VA","24201",36.5950849,-82.1856749))
        addresses.add(new Address(241848,"Finale Desserts - Park Plaza","Boston","MA","02116",42.3514822,-71.0686422))
        addresses.add(new Address(118840090,"Costa Vida - Colleyville","Colleyville","TX","76034",32.891007,-97.1480009))
        addresses.add(new Address(252821,"Saus","Boston","MA","02109",42.3611244,-71.0568148))
        addresses.add(new Address(376950,"El Colima","Nashua","NH","03060",42.7600848,-71.4691775))
        addresses.add(new Address(452302,"Olde Tymes","Norwich","CT","06360",41.52163059999999,-72.09110709999999))
    }

    PosOrder getLatest() {
        PosOrder order = orders.get(++count % 10)
        order.address = addresses.get(count % 10)
        order.closed = new Date()
        order
    }

}
