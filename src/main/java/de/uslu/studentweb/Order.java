package de.uslu.studentweb;

import java.util.HashMap;

public class Order {

    private String id;
    private final HashMap<String, Product> products;

    public Order(HashMap<String, Product> products) {
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public HashMap<String, Product> getProducts() {
        return products;
    }
}
