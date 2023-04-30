# Ecommerce-Backend-API-Service

## Framework

![ecommercebackendapi drawio](https://user-images.githubusercontent.com/78866239/235349902-801acd55-4cae-4154-baa6-ae73fe489faf.png)

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
| field name | data type |
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
| field name | data type |
|:--------:|:--------:|
|user_id|INT|
|email|VARCHAR(256)|
|password|VARCHAR(256)|
|created_date|TIMESTAMP|
|last_modified_date|TIMESTAMP|
 
### order
| field name | data type |
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
