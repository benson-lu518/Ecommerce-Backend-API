package com.bensonlu.ecommercebackendapi.service.impl;

import com.bensonlu.ecommercebackendapi.dao.OrderDao;
import com.bensonlu.ecommercebackendapi.dao.ProductDao;
import com.bensonlu.ecommercebackendapi.dto.BuyItem;
import com.bensonlu.ecommercebackendapi.dto.CreateOrderRequest;
import com.bensonlu.ecommercebackendapi.model.OrderItem;
import com.bensonlu.ecommercebackendapi.model.Product;
import com.bensonlu.ecommercebackendapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Transactional  //will rollback if throw exception
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        //caculate total amount

        int totalAmount=0;
        List<OrderItem> orderItemList=new ArrayList<>();
        for(BuyItem buyItem: createOrderRequest.getBuyItemList()){
            //get product information
            Product product=productDao.getProductById(buyItem.getProductId());

            //caculate amount
            int amount=buyItem.getQuantity()*product.getPrice();
            totalAmount=totalAmount+amount;

            //transfer buyItem to OrderItem
            OrderItem orderItem=new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);
            orderItemList.add(orderItem);
        }


        //create order
        Integer orderId=orderDao.createOrder(userId,totalAmount);

        //pass orderItemList to Dao
        orderDao.createOrderItems(orderId,orderItemList);

        return orderId;
    }
}
