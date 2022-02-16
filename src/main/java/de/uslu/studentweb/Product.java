package de.uslu.studentweb;

public class Product {

    private final String id;
    private final String name;

    public Product(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
