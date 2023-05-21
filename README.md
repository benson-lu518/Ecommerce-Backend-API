# Ecommerce-Backend-API-Services

## About
Used Java Spring Boot to build e-commerce backend API services and provide CRUD, product, item, user, log-in, register, etc.  
Skills: JAVA, Spring Boot, JDBC, H2, JUnit, MySQL, REST API, intelliJ IDEA
## Framework

![ecommercebackendapi drawio](https://user-images.githubusercontent.com/78866239/235349955-0e1789a8-1d58-45da-83dc-378f37daabb0.png)


## General flow 
(1.	Get the request from the client and variables from the request body  
(2.	Set the variables to dto (stores necessary variables for dao(SQL))  
(3.	Pass dto to Service  
&nbsp;&nbsp;In Service, It may have some business logic (conditional expression, calculation, check etc.)  
(4.	Pass dto or other variables to dao  
(5.	Dao implements the SQL execution     
&nbsp;&nbsp;If it returns multiple rows then use rowmapper to turn Result into model.object    
&nbsp;&nbsp;Then pass to namedParameterJdbcTemplate and return the List  
(6.	(if needed) Set the List to Page  
(7.	Return ResponseEntity.status(HttpStatus.OK).body() to the Frontend  

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
