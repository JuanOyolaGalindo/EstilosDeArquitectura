package co.edu.unbosque.sw2.products_service.controller;

import co.edu.unbosque.sw2.products_service.model.Product;
import co.edu.unbosque.sw2.products_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProductsByIds(@RequestParam List<String> ids) {
        return productService.getProductsByIds(ids);
    }
}