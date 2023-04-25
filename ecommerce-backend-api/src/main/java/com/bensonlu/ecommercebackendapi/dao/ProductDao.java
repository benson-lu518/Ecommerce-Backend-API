package com.bensonlu.ecommercebackendapi.dao;

import com.bensonlu.ecommercebackendapi.dto.ProductRequest;
import com.bensonlu.ecommercebackendapi.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts();

    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);


}
