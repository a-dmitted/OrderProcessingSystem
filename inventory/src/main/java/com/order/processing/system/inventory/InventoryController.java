package com.order.processing.system.inventory;

import com.order.processing.system.common.InventoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @GetMapping("/{itemId}")
    public ResponseEntity<?> checkAvailability(@PathVariable String itemId) {
        // Assume this method checks the inventory (mock example)
        boolean isAvailable = checkInventory(itemId);
        return ResponseEntity.ok(new InventoryResponse(itemId, isAvailable));
    }

    private boolean checkInventory(String itemId) {
        // Logic to check inventory
        return true; // Placeholder response
    }

}