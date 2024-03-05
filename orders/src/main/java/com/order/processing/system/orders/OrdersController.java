package com.order.processing.system.orders;

import com.order.processing.system.common.InventoryResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final RestTemplate restTemplate;

    public OrdersController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderRequest) {
        // For each item in the order, check availability with the Inventory Service
        for (Item item : orderRequest.getItems()) {
            String inventoryCheckUrl = "http://localhost:8082/inventory/" + item.getItemId();
            InventoryResponse response = restTemplate.getForObject(inventoryCheckUrl, InventoryResponse.class);
            if (!response.isAvailable()) {
                return ResponseEntity.badRequest().body("Item " + item.getItemId() + " is not available");
            }
        }

        // Process the order...
        return ResponseEntity.ok().body("Order placed successfully");
    }
}
