package co.edu.unbosque.sw2.products_service.service;

import co.edu.unbosque.sw2.products_service.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final List<Product> products = List.of(
            new Product("1", "Producto 1", BigDecimal.valueOf(10.00)),
            new Product("2", "Producto 2", BigDecimal.valueOf(20.00)),
            new Product("3", "Producto 3", BigDecimal.valueOf(30.00))
    );

    public List<Product> getProductsByIds(List<String> ids) {
        return products.stream()
                .filter(product -> ids.contains(product.getId()))
                .collect(Collectors.toList());
    }
}