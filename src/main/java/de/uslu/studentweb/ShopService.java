package de.uslu.studentweb;

import java.util.Collection;
import java.util.Optional;

public class ShopService {

    private OrderRepo myOrders;
    private ProductRepo myProducts;

    public ShopService(OrderRepo myOrders, ProductRepo myProducts) {
        this.myOrders = myOrders;
        this.myProducts = myProducts;
    }

    public Optional<Product> getProduct(String id) {
        return Optional.ofNullable(myProducts.get(id));
    }

    public void addProduct(Product newProduct) {
        myProducts.add(newProduct);
    }

    public Collection<Product> listProducts() {
        return myProducts.list();
    }

    public void addOrder(Order newOrder) {
        myOrders.add(newOrder);
    }

    public Optional<Order> getOrder(String id) {
        return Optional.ofNullable(myOrders.get(id));
    }

    public Collection<Order> listOrders() {
        return myOrders.list();
    }

}
