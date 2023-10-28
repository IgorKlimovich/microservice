package com.example.orderservice.service.impi;

import com.example.orderservice.dto.OrderLineItemsDto;
import com.example.orderservice.model.OrderLineItems;
import com.example.orderservice.service.UtilService;
import org.springframework.stereotype.Service;

@Service
public class UtilServiceImpl implements UtilService {

    public OrderLineItems mapToOrderLineItems(OrderLineItemsDto orderLineItemsDto){
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setId(orderLineItemsDto.getId());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItems.getSkuCode());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        return orderLineItems;
    }
}
