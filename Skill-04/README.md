# SKILL-4: Spring Dependency Injection Demo

This project demonstrates both Constructor and Setter Injection in Spring Framework using two different configuration approaches:

1. **XML Configuration** - Using `applicationContext.xml`
2. **Annotation Configuration** - Using `@Component` and `@Configuration` annotations

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       ├── klu/
│   │       │   └── AppConfig.java
│   │       ├── xmlconfig/
│   │       │   ├── Student.java
│   │       │   └── MainApp.java
│   │       └── annotationconfig/
│   │           ├── Student.java
│   │           └── MainAnnotation.java
│   └── resources/
│       └── applicationContext.xml
└── pom.xml
```

## XML Configuration Approach (Constructor + Setter Injection)

### Student Class (XML Config)
- Uses constructor injection for initial values
- Uses setter injection to override values
- Located at `com.klu.xmlconfig.Student`

### XML Configuration
- Defined in `src/main/resources/applicationContext.xml`
- Bean configured with constructor args and property setters

### Main Class
- Located at `com.klu.xmlconfig.MainApp`
- Loads Spring IoC container from XML config
- Retrieves and displays student information

## Annotation Configuration Approach

### Student Class (Annotation Config)
- Uses `@Component` annotation
- Has default values set in constructor
- Setter methods for course and year
- Located at `com.klu.annotationconfig.Student`

### Configuration Class
- Uses `@Configuration` and `@ComponentScan` annotations
- Scans the `com.klu.annotationconfig` package

### Main Class
- Located at `com.klu.annotationconfig.MainAnnotation`
- Loads Spring IoC container from annotation config
- Sets values using setter injection and displays student information

## Running the Applications

### For XML Configuration:
```bash
mvn compile
java -cp target/classes:target/dependency/* com.klu.xmlconfig.MainApp
```

### For Annotation Configuration:
```bash
mvn compile
java -cp target/classes:target/dependency/* com.klu.annotationconfig.MainAnnotation
```

## Expected Outputs

### XML Configuration Output:
```
ID: 101
Name: Yeswanth
Course: Full Stack Development
Year: 4
```

### Annotation Configuration Output:
```
102 Rahul Spring Framework 2
```