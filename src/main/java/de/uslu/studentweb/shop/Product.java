package de.uslu.studentweb.shop;

public class Product {

    private String id;
    private String name;

    public Product(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Product() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
