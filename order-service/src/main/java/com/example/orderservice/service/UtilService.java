package com.example.orderservice.service;

import com.example.orderservice.dto.OrderLineItemsDto;
import com.example.orderservice.model.OrderLineItems;

public interface UtilService {

    OrderLineItems mapToOrderLineItems(OrderLineItemsDto orderLineItemsDto);
}
