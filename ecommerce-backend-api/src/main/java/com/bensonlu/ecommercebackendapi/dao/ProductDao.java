package com.bensonlu.ecommercebackendapi.dao;

import com.bensonlu.ecommercebackendapi.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
