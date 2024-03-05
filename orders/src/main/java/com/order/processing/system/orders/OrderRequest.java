package com.order.processing.system.orders;

import java.util.List;

public class OrderRequest {
    public List<Item> getItems() {
        return items;
    }

    private List<Item> items;

}
