package de.uslu.studentweb;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.HashMap;
@Repository
public class OrderRepo {

    private HashMap<String, Order> orders;

    public OrderRepo(){
        orders = new HashMap<>();
    }

    public Collection<Order> list(){
        return orders.values();
    }

    public Order get(String id){
        return orders.get(id);
    }

    public void add(Order newOrder){
        orders.put(newOrder.getId(), newOrder);
    }


}
