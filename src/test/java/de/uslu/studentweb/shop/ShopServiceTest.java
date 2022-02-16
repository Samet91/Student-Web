package de.uslu.studentweb.shop;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ShopServiceTest {

    @Test
    void shouldReturnProducts() {
        List<Product> products = List.of(new Product(), new Product());

        ProductRepo repoMock = mock(ProductRepo.class);
        when(repoMock.get("3"))
                .thenReturn((new Product("name", "1")));
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(orderRepo, repoMock);
        Product actual = shopService.getProduct("3").get();
        assertEquals("name", actual.getName());

    }

}