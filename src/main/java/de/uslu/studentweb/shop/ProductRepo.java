package de.uslu.studentweb.shop;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
@Repository
public class ProductRepo {

    private HashMap<String, Product> products = new HashMap<>();

    public ProductRepo() {
    }

    public Collection<Product> list(){
        return products.values();
    }

    public Product get(String id){
        return products.get(id);
    }

    public void add(Product newProduct){
        products.put(newProduct.getId(), newProduct);
    }
}
