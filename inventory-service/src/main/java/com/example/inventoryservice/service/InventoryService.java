package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryDto;

import java.util.List;

public interface InventoryService {
    List<InventoryDto> isInStock(List<String> skuCode);
}
