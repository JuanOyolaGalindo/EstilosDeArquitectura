package co.edu.unbosque.sw2.checkout_service.controller;

import co.edu.unbosque.sw2.checkout_service.client.ProductServiceClient;
import co.edu.unbosque.sw2.checkout_service.model.Checkout;
import co.edu.unbosque.sw2.checkout_service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private ProductServiceClient productServiceClient;

    @GetMapping
    public Checkout getCheckout(@RequestParam List<String> productIds) {
        List<Product> products = productServiceClient.getProductsByIds(productIds);


        BigDecimal totalValue = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        Checkout checkout = new Checkout();
        checkout.setId(UUID.randomUUID().toString());
        checkout.setUrl("http://localhost:8082/checkout/" + checkout.getId());
        checkout.setTotalValue(totalValue);
        checkout.setPaymentMethods(List.of("Credit Card", "PayPal", "Bank transfer"));
        checkout.setProducts(products);

        return checkout;
    }
}
