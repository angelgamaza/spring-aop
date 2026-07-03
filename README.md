# Spring AOP (Aspect Oriented Programming) Example

A compact Spring Boot that demonstrates how to use Spring AOP for:

- Logging method execution flow.
- Measuring performance of service operations.
- Handling exceptions centrally with aspects.

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.2-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-%23C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

## 📦 Why this project exists

This sample is designed to help developers understand Spring AOP by combining real AOP concerns into a simple Spring Boot application. It shows how aspects can be used to separate
cross-cutting concerns from business logic and keep service code clean.

## 🎯 Key Features

- `LoggingAspect`: logs method entry, exit and return values for `LoggingService`.
- `PerformanceAspect`: measures execution time of `PerformanceService` methods.
- `ExceptionAspect`: captures runtime exceptions thrown by `ExceptionService` and logs them centrally.

## 📂 Project Structure

- `src/main/java/com/gamaza/examples/springaop/`
    - `SpringAopApplication.java` — Application entry point
    - `aspect/` — AOP aspects for logging, performance and exception handling
    - `service/` — Service interfaces and implementations
- `src/main/resources/application.yml` — Spring Boot configuration

## 🚀 Getting Started

### Prerequisites

- Java 21+.
- Maven 3.9.x+.

### Build the Application

```bash
mvn clean package
```

### Run the Application

You can start the application with Maven:

```bash
mvn spring-boot:run
```

Or run the packaged JAR directly:

```bash
java -jar target/spring-aop-1.0.0.jar
```

## 📤 Expected Output

When the application runs, the console output highlights the AOP behavior for each service:

- Logging aspect messages for `LoggingService`.
- Execution timing for `PerformanceService`.
- Exception interception for `ExceptionService`.

Example output:

```bash
INFO  [...] c.g.e.springaop.SpringAopApplication                         : ------ Logging service -------
INFO  [...] c.g.e.springaop.aspect.LoggingAspect                         : Before method [LoggingServiceImpl.action1()] execution
INFO  [...] c.g.e.springaop.service.logging.impl.LoggingServiceImpl      : Action 1
INFO  [...] c.g.e.springaop.aspect.LoggingAspect                         : After method [LoggingServiceImpl.action1()] execution
INFO  [...] c.g.e.springaop.aspect.LoggingAspect                         : Before method [LoggingServiceImpl.action2()] execution
INFO  [...] c.g.e.springaop.service.logging.impl.LoggingServiceImpl      : Action 2
INFO  [...] c.g.e.springaop.aspect.LoggingAspect                         : After method [LoggingServiceImpl.action2()] execution
INFO  [...] c.g.e.springaop.aspect.LoggingAspect                         : Before method [LoggingServiceImpl.action3()] execution
INFO  [...] c.g.e.springaop.service.logging.impl.LoggingServiceImpl      : Action 3
INFO  [...] c.g.e.springaop.aspect.LoggingAspect                         : After method [LoggingServiceImpl.action3()] execution with return value: [UUID]
INFO  [...] c.g.e.springaop.SpringAopApplication                         : Action 3 result: [UUID]
INFO  [...] c.g.e.springaop.SpringAopApplication                         : ------ Performance service -------
INFO  [...] c.g.e.springaop.aspect.PerformanceAspect                     : [PerformanceServiceImpl.action1] executed in XXXX ms
INFO  [...] c.g.e.springaop.aspect.PerformanceAspect                     : [PerformanceServiceImpl.action2] executed in XXXXX ms
INFO  [...] c.g.e.springaop.SpringAopApplication                         : ------ Exception service -------
INFO  [...] c.g.e.springaop.aspect.ExceptionAspect                       : Exception in [ExceptionServiceImpl.action1()] with message: Unhandled exception with message: Exception in Action 1
ERROR [...] c.g.e.springaop.SpringAopApplication                         : Catched exception in main method
```

## 📚 Notes

This example is intentionally minimal and focused on explaining Spring AOP patterns. It is a practical starting point for building more advanced aspect-oriented behavior in Spring
applications.

## 👨‍💻 Author

Ángel Gamaza - angel.gamaza@gmail.com
