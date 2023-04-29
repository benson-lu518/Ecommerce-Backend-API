package com.bensonlu.ecommercebackendapi.service;

import com.bensonlu.ecommercebackendapi.dto.CreateOrderRequest;
import com.bensonlu.ecommercebackendapi.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

}
