package co.edu.unbosque.sw2.checkout_service.client;

import co.edu.unbosque.sw2.checkout_service.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "products-service")
public interface ProductServiceClient {
    @GetMapping("/products")
    List<Product> getProductsByIds(@RequestParam List<String> ids);
}
