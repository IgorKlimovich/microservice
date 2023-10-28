package com.example.inventoryservice.service.impl;

import com.example.inventoryservice.dto.InventoryDto;
import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.service.InventoryService;
import com.example.inventoryservice.repository.InventoryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

//    @PostConstruct
//    public void  init(){
//        Inventory inventory = new Inventory();
//        inventory.setSkuCode("iphone_13");
//        inventory.setQuantity(100);
//
//        Inventory inventory1 = new Inventory();
//        inventory1.setSkuCode("iphone_13_red");
//        inventory1.setQuantity(0);
//        inventoryRepository.save(inventory);
//        inventoryRepository.save(inventory1);
//    }

    @Transactional(readOnly = true)
    public List<InventoryDto> isInStock(List<String> skuCode) {
        log.info("checking inventory");
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                    InventoryDto.builder()
                            .skuCode(inventory.getSkuCode())
                            .id(inventory.getId())
                            .isInStock(inventory.getQuantity()>0)
                            .build()
                ).toList();
    }
}
