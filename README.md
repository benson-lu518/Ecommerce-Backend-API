# Ecommerce-Backend-API-Services

## About
Use Java Spring Boot to build e-commerce backend API services and provide CRUD, product, item, user, log-in, register, etc.  
Skills: JAVA, Spring Boot, JDBC, H2, JUnit, MySQL, REST API, intelliJ IDEA
## Framework

![ecommercebackendapi drawio](https://user-images.githubusercontent.com/78866239/235349955-0e1789a8-1d58-45da-83dc-378f37daabb0.png)

## Product
- Query product lists
- Create/Read/Update/Delete(CRUD) products

## User
- Register
- Login

## Item
- Order items
- Query order lists

## Unit Test
- H2 Database


## Database (MySQL)(JDBC)
### Table
### product 
| column name | data type |
|:--------:|:--------:|
| product_id | INT |
|product_name|VARCHAR(128)|
|category|VARCHAR(32)|
|image_url|VARCHAR(256)|
|price|INT|
|stock|INT|
|description|VARCHAR(1024)|
|created_date|TIMESTAMP|
|last_modified_date|TIMESTAMP|

### user
| column name | data type |
|:--------:|:--------:|
|user_id|INT|
|email|VARCHAR(256)|
|password|VARCHAR(256)|
|created_date|TIMESTAMP|
|last_modified_date|TIMESTAMP|
 
### order
| column name | data type |
|:--------:|:--------:|
|order_id|INT|
|user_id|INT|
|total_amount|INT|
|created_date|TIMESTAMP|
|last_modified_date|TIMESTAMP|
 
### order_item
| field name | data type |
|:--------:|:--------:|
|order_item_id|INT|
|order_id|INT|
|product_id|INT|
|quantity|INT|
|amount|INT|
