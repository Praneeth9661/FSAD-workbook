# Skill-05-Autowiring

Spring Autowiring Demo Project

## Project Structure
```
Skill-05-Autowiring/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── klu/
│                   ├── AppConfig.java
│                   ├── Certification.java
│                   ├── MainApp.java
│                   ├── MainAppConstructor.java
│                   ├── Student.java
│                   └── StudentConstructor.java
└── pom.xml
```

## Dependencies
- Spring Context 5.3.30

## How to Run

### Field Injection (Main Demo)
```bash
mvn compile
mvn exec:java
```

Expected Output:
```
Student ID: 30418
Name: Yeswanth
Gender: Male
Certification ID: 501
Certification Name: AWS Certified Developer
Completion Date: 12-02-2026
```

### Constructor Injection (Alternative)
```bash
mvn compile
java -cp target/classes;[spring-jars] com.klu.MainAppConstructor
```

## Key Concepts Demonstrated
1. **@Component** - Marks classes for Spring's component scanning
2. **@Autowired** - Field injection (Student.java)
3. **@Autowired** - Constructor injection (StudentConstructor.java)
4. **@Configuration** - Configuration class
5. **@ComponentScan** - Package scanning for components
6. **AnnotationConfigApplicationContext** - Spring context initialization

## Best Practices
- Constructor injection is preferred over field injection in production code
- Field injection is simpler for demos and learning
- All dependencies should be properly managed through Spring's IoC container