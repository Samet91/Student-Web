package de.uslu.studentweb.shop;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShopServiceTest {

    @Test
    void shouldReturnProduct() {
        List<Product> products = List.of(new Product(), new Product());

        ProductRepo repoMock = mock(ProductRepo.class);
        when(repoMock.get("3"))
                .thenReturn((new Product("name", "1")));

        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(orderRepo, repoMock);
        Product actual = shopService.getProduct("3").get();
        assertEquals("name", actual.getName());
    }

    @Test
    void shouldAddProduct() {
        Product product = new Product();

        ProductRepo dbMock = mock(ProductRepo.class);

        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(orderRepo, dbMock);

        shopService.addProduct(product);

        verify(dbMock).add(product);

    }
}