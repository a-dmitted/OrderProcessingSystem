package com.order.processing.system.orders;

import com.order.processing.system.utils.Version;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
    @GetMapping("/version")
    public Version version() {
        return new Version();
    }
}
