package com.bensonlu.ecommercebackendapi.service.impl;

import com.bensonlu.ecommercebackendapi.dao.ProductDao;
import com.bensonlu.ecommercebackendapi.dto.ProductRequest;
import com.bensonlu.ecommercebackendapi.model.Product;
import com.bensonlu.ecommercebackendapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }
}
