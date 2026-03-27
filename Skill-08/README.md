# Skill-08-SpringBoot

## Overview
Spring Boot project demonstrating JPQL & Query Methods for managing products.

**Technology Stack:**
- Spring Boot 3.2.0
- Spring Data JPA
- MySQL Database
- Java 17

## Project Structure
```
Skill-08-SpringBoot/
├── src/main/java/com/fsad/skill08/
│   ├── controller/
│   │   └── ProductController.java
│   ├── service/
│   │   └── ProductService.java
│   ├── repository/
│   │   └── ProductRepository.java
│   ├── model/
│   │   └── Product.java
│   └── Skill08SpringBootApplication.java
├── src/main/resources/
│   └── application.properties
└── pom.xml
```

## Features

### Query Methods
- `findByCategory(String)` - Query by product category
- `findByPriceBetween(double, double)` - Query by price range

### JPQL Queries
- `sortProductsByPrice()` - Sort products by price ascending
- `findExpensiveProducts(double)` - Find products above price
- `findProductsByCategoryJPQL(String)` - Query by category using JPQL

## API Endpoints

### 1. Add Product
```
POST /products
Content-Type: application/json

{
  "name": "Laptop",
  "category": "Electronics",
  "price": 50000
}
```

### 2. Get by Category
```
GET /products/category/{category}
Example: GET /products/category/Electronics
```

### 3. Filter by Price Range
```
GET /products/filter?min=1000&max=50000
```

### 4. Get Sorted Products
```
GET /products/sorted
```

### 5. Find Expensive Products
```
GET /products/expensive/{price}
Example: GET /products/expensive/30000
```

## Database Configuration

Database: `fsad_db`
Username: `root`
Password: `root123`

### SQL Setup
```sql
CREATE DATABASE fsad_db;
```

### application.properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fsad_db
spring.datasource.username=root
spring.datasource.password=root123

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

server.port=8080
```

## Running the Application

1. Prerequisites:
   - MySQL Server running on localhost:3306
   - Database `fsad_db` created

2. Build and Run:
```bash
mvn clean install
mvn spring-boot:run
```

3. The application will start on `http://localhost:8080`

## Testing with cURL

```bash
# Add Product
curl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Laptop","category":"Electronics","price":50000}'

# Get by Category
curl http://localhost:8080/products/category/Electronics

# Filter by Price
curl "http://localhost:8080/products/filter?min=1000&max=50000"

# Get Sorted
curl http://localhost:8080/products/sorted

# Find Expensive
curl http://localhost:8080/products/expensive/30000
```
