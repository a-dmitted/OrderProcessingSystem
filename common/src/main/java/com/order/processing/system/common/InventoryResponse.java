package com.order.processing.system.common;

public class InventoryResponse {
    private String itemId;
    private boolean available;

    public InventoryResponse() {}

    public InventoryResponse(String itemId, boolean available) {
        this.itemId = itemId;
        this.available = available;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}