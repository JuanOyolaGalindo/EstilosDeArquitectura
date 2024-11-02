package co.edu.unbosque.sw2.products_service.service;

import co.edu.unbosque.sw2.products_service.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {


    private final List<Product> products = List.of(
            new Product("1", "Producto 1", 10.00),
            new Product("2", "Producto 2", 25.00),
            new Product("3", "Producto 3", 30.00),
            new Product("4", "Producto 4", 18.00),
            new Product("5", "Producto 5", 21.00),
            new Product("6", "Producto 6", 17.00),
            new Product("7", "Producto 7", 27.00),
            new Product("8", "Producto 8", 30.00),
            new Product("9", "Producto 9", 25.00)
    );

    public List<Product> getProductsByIds(List<String> ids) {
        System.out.println("Usado en instancia " + this);
        return products.stream()
                .filter(product -> ids.contains(product.getId()))
                .collect(Collectors.toList());
    }
}