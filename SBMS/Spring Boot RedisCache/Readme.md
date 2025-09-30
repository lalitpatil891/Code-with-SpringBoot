# Spring Boot REST Application with MySQL, Spring Data JPA, and Redis Caching

This project is a sample Spring Boot RESTful web service demonstrating CRUD operations on a `Product` entity using:

- **Spring Data JPA** for MySQL database interaction
- **Spring Cache Abstraction** with **Redis** as the cache provider
- **Lombok** to reduce boilerplate code
- **Spring Web** for REST API development
- **Spring Boot DevTools** for hot reload during development

---

## Table of Contents

- [Features](#features)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Setup and Installation](#setup-and-installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Caching Behavior](#caching-behavior)
- [Troubleshooting](#troubleshooting)
- [Notes](#notes)

---

## Features

- Create, read, update, and delete `Product` entities stored in a MySQL database.
- Use Redis as a distributed cache to improve read performance.
- Cache management with annotations:
  - `@Cacheable` for caching read operations
  - `@CachePut` for updating cache on save/update
  - `@CacheEvict` for removing cache entries on delete
- RESTful API endpoints with proper HTTP status codes.
- Auto-creation of database tables via Hibernate.
- Clean and maintainable code using Lombok.

---

## Technology Stack

| Technology           | Version / Description                      |
|---------------------|--------------------------------------------|
| Spring Boot         | 3.1.0 (or latest stable)                    |
| Spring Data JPA     | Included in Spring Boot starter             |
| MySQL               | 8.x (or compatible)                         |
| Redis               | 7.x (or compatible)                         |
| Java                | 17 or higher                                |
| Lombok              | 1.18.x (for annotations like @Data)        |
| Maven               | For build and dependency management         |

---

## Prerequisites

- **Java 17+** installed and configured (`java -version`)
- **MySQL Server** installed and running
- **Redis Server** installed and running
- Maven installed (`mvn -v`)
- IDE (IntelliJ IDEA, Eclipse, VSCode) recommended

---

## Setup and Installation

### 1. Clone the repository

```bash
git clone <repository-url>
cd boot-rest-redis-cache-proj01
```

### 2. Configure MySQL Database

- Create a database named `ntspbms617` (or update the name in `application.properties`):

```sql
CREATE DATABASE ntspbms617;
```

- Update MySQL username and password in `src/main/resources/application.properties` if different from defaults:

```properties
spring.datasource.username=root
spring.datasource.password=root
```

### 3. Start Redis Server

- Install Redis from [https://redis.io/download](https://redis.io/download)
- Start Redis server:

```bash
redis-server
```

- Verify Redis is running:

```bash
redis-cli ping
# Should respond with: PONG
```

### 4. Build the Project

```bash
mvn clean install
```

---

## Running the Application

Run the Spring Boot application using your IDE or command line:

```bash
mvn spring-boot:run
```

The application will start on port **4041** by default.

---

## API Endpoints

| HTTP Method | URL                      | Description                  | Request Body / Params                  | Response                      |
|-------------|--------------------------|------------------------------|--------------------------------------|-------------------------------|
| POST        | `/product-api/save`      | Add a new product             | JSON body: `{ "pname": "...", "price": ..., "qty": ... }` | 201 Created, saved product info |
| GET         | `/product-api/find/{pid}`| Find product by ID            | Path variable: `pid` (Integer)       | 200 OK, product JSON           |
| GET         | `/product-api/report`    | Get all products              | None                                 | 200 OK, list of products JSON |
| DELETE      | `/product-api/delete/{pid}` | Delete product by ID         | Path variable: `pid` (Integer)       | 200 OK, success/failure message|

---

## Caching Behavior

- **Cache Name:** `prods`
- **@Cacheable:** Caches results of `findProductById` and `showAllProducts`.
- **@CachePut:** Updates cache when a product is added or updated.
- **@CacheEvict:** Removes product from cache when deleted.

Redis stores cached data, reducing database load and improving response times for repeated requests.

---

## Troubleshooting

- **405 Method Not Allowed on DELETE:**
  - Ensure the controller method is annotated with `@DeleteMapping`.
  - Verify the HTTP client sends a DELETE request.
  - Check for Spring Security or filters blocking DELETE.
- **Redis connection errors:**
  - Confirm Redis server is running on `localhost:6379`.
  - Check firewall or port conflicts.
- **MySQL connection errors:**
  - Verify database exists and credentials are correct.
  - Ensure MySQL server is running.
- **Cache not working:**
  - Confirm `@EnableCaching` is present on the main class.
  - Check `spring.cache.type=redis` in `application.properties`.
  - Enable debug logging for cache: add `logging.level.org.springframework.cache=DEBUG`.

---

## Notes

- The project uses Jakarta EE 9+ namespaces (`jakarta.persistence`, `jakarta.servlet`) compatible with Spring Boot 3.x.
- Lombok requires IDE plugin support to avoid compilation errors.
- Hibernate auto-creates the `CACHE_PRODUCT` table on startup.
- Redis must be running before starting the application to avoid cache connection errors.
- You can customize Redis and MySQL connection properties in `application.properties`.

---