package de.uslu.studentweb;

import java.util.Collection;
import java.util.HashMap;

public class ProductRepo {

    private HashMap<String, Product> products;

    public ProductRepo(HashMap<String, Product> products) {
       this.products = products;
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
