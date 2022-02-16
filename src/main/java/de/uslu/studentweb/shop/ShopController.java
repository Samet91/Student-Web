package de.uslu.studentweb.shop;


import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping()
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/products")
    public Collection<Product> allProducts() {
        return shopService.listProducts();
    }

    @GetMapping("/orders")
    public Collection<Order> allOrders() {
        return shopService.listOrders();
    }

    @PostMapping("/orders")
    public void addOrder(@RequestBody Order newOrder) {
        shopService.addOrder(newOrder);
    }

}
