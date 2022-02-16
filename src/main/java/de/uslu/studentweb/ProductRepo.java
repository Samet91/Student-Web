package de.uslu.studentweb;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
@Repository
public class ProductRepo {

    private HashMap<String, Product> products = new HashMap<>();

    public ProductRepo() {
       var product1 = new Product("Sam", "1");
       var product2 = new Product("Max", "2");
       products.put(product1.getId(), product1);
       products.put(product2.getId(), product2);
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
