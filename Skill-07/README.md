# Skill-07-RestAPI: REST API CRUD Operations using ResponseEntity

This project demonstrates REST API CRUD operations using Spring Boot, Service Layer, and ResponseEntity.

## Technologies Used
- Spring Boot 3.2.0
- Spring Data JPA
- MySQL Database
- Maven
- Java 17

## Project Structure
```
Skill-07-RestAPI/
├── src/main/java/com/klu/restapi/
│   ├── RestApiApplication.java      # Main Application Class
│   ├── controller/
│   │   └── CourseController.java    # REST Controller with ResponseEntity
│   ├── service/
│   │   └── CourseService.java       # Business Logic Layer
│   ├── repository/
│   │   └── CourseRepository.java    # Data Access Layer (JPA)
│   └── entity/
│       └── Course.java              # JPA Entity
└── src/main/resources/
    └── application.properties       # Database Configuration
```

## API Endpoints

### 1. Add Course (POST)
```
POST http://localhost:8080/courses
Content-Type: application/json

{
    "title": "Java",
    "duration": "3 months",
    "fee": 5000
}
```

### 2. Get All Courses (GET)
```
GET http://localhost:8080/courses
```

### 3. Get Course by ID (GET)
```
GET http://localhost:8080/courses/{id}
```

### 4. Update Course (PUT)
```
PUT http://localhost:8080/courses/{id}
Content-Type: application/json

{
    "title": "Advanced Java",
    "duration": "4 months",
    "fee": 7000
}
```

### 5. Delete Course (DELETE)
```
DELETE http://localhost:8080/courses/{id}
```

### 6. Search Course by Title (GET)
```
GET http://localhost:8080/courses/search/{title}
```

## Setup Instructions

### Prerequisites
- Java 17 or higher
- MySQL Server running
- Maven installed

### Database Configuration
1. Create a MySQL database named `fsad`:
```sql
CREATE DATABASE fsad;
```

2. Update `application.properties` if your MySQL credentials differ:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fsad
spring.datasource.username=root
spring.datasource.password=Yeswanth.25
```

### Running the Application

#### Option 1: Using Maven
```bash
cd Skill-07-RestAPI
mvn spring-boot:run
```

#### Option 2: Using IDE
Run `RestApiApplication.java` from your IDE

The application will start on `http://localhost:8080`

## Testing with Postman

All endpoints can be tested using Postman. Expected responses:
- **200 OK** - Successful GET, PUT, DELETE operations
- **201 CREATED** - Successful POST operation
- **404 NOT FOUND** - Resource not found
- **400 BAD REQUEST** - Invalid request body

## Viva Questions

**Q1: What is ResponseEntity?**
A: ResponseEntity is used to return HTTP response with status code and body together.

**Q2: Difference between @PostMapping and @PutMapping?**
A: @PostMapping creates a new resource, while @PutMapping updates an existing resource.

**Q3: What are HTTP Status Codes?**
A: They indicate the result of an API request (success or error).

**Q4: What happens when an invalid ID is passed?**
A: The API returns 404 NOT FOUND status.

**Q5: Can ResponseEntity return both data and status?**
A: Yes, ResponseEntity returns body and status code together.

## Notes
- Hibernate automatically creates/updates the Course table (ddl-auto=update)
- SQL queries are logged in console (show-sql=true)
- All endpoints return JSON responses
