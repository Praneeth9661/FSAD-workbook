# Skill-06-Spring-MVC

Spring MVC Web Request Handling Demo

## Project Structure
```
Skill-06-Spring-MVC/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── klu/
│                   ├── SpringMvcDemoApplication.java
│                   ├── controller/
│                   │   └── LibraryController.java
│                   └── model/
│                       └── Book.java
└── pom.xml
```

## Dependencies
- Spring Boot 3.2.0
- Spring Web Starter
- Spring Boot DevTools (optional)

## API Endpoints

### GET Endpoints:
1. `/welcome` - Welcome message
2. `/count` - Returns book count (150)
3. `/price` - Returns sample price (499.99)
4. `/books` - Returns list of book titles
5. `/books/{id}` - Returns book details by ID
6. `/search?title={title}` - Search for books by title
7. `/author/{name}` - Get books by author name
8. `/viewbooks` - View all added books

### POST Endpoint:
- `/addbook` - Add a new book (JSON body required)

## How to Run

```bash
mvn spring-boot:run
```

Server will start on: http://localhost:8080

## Testing Examples

### Add a book (POST):
```bash
curl -X POST http://localhost:8080/addbook \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "title": "Spring in Action",
    "author": "Craig Walls",
    "price": 650
  }'
```

### View books (GET):
```bash
curl http://localhost:8080/viewbooks
```

### Other endpoints:
- http://localhost:8080/welcome
- http://localhost:8080/count
- http://localhost:8080/price
- http://localhost:8080/books
- http://localhost:8080/books/10
- http://localhost:8080/search?title=Java
- http://localhost:8080/author/James