package com.bensonlu.ecommercebackendapi.controller;

import com.bensonlu.ecommercebackendapi.constant.ProductCategory;
import com.bensonlu.ecommercebackendapi.dto.ProductQueryParams;
import com.bensonlu.ecommercebackendapi.dto.ProductRequest;
import com.bensonlu.ecommercebackendapi.model.Product;
import com.bensonlu.ecommercebackendapi.service.ProductService;
import com.bensonlu.ecommercebackendapi.util.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Page<Product>>getProducts(
            //conditional filtering
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,
            //sorting type
            @RequestParam(defaultValue = "created_date") String orderBy,
            @RequestParam(defaultValue = "desc") String sort, //descending or ascending
            //paging
            @RequestParam(defaultValue = "5") @Max(100) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset
            ){

        ProductQueryParams productQueryParams=new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);
        //get product list
        List<Product> productList=productService.getProducts(productQueryParams);
        //get total products num
        Integer total=productService.countProduct(productQueryParams);

        //paging
        Page<Product> page=new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(productList);


        return ResponseEntity.status(HttpStatus.OK).body(page);
    }


    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
        Product product = productService.getProductById(productId);
        if(product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest){
        Integer productId=productService.createProduct(productRequest);
        Product product =productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest){

        //check product if exists
        Product product =productService.getProductById(productId);

        if (product==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        // update product data
        productService.updateProduct(productId,productRequest);

        Product updateProduct =productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();



    }
}
