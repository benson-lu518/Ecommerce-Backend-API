package com.bensonlu.ecommercebackendapi.service;

import com.bensonlu.ecommercebackendapi.dto.ProductRequest;
import com.bensonlu.ecommercebackendapi.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);
    void deleteProductById(Integer productId);

}
