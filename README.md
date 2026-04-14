# TaskFlow Backend - Zomato Assignment

## Overview

TaskFlow is a backend system built using Spring Boot that allows users to:

* Register/Login using JWT Authentication
* Create and manage projects
* Secure APIs using token-based authentication

---

## Tech Stack

* Java
* Spring Boot
* Spring Security (JWT)
* PostgreSQL
* Maven

---

##  Authentication

* JWT-based authentication
* Login API returns token
* Token must be passed in headers:

```
Authorization: Bearer <token>
```

---

##  API Endpoints

###  Auth

* POST `/auth/login`

### Projects

* POST `/projects` → Create project
* GET `/projects` → Get all projects
* GET `/projects/{id}` → Get project by ID
* DELETE `/projects/{id}` → Delete project

---

##  Setup Instructions

### 1. Clone repo

```
git clone https://github.com/shanmugamkan26-dot/taskflow-shanmugas-undaram
```

### 2. Configure DB

Update `application.properties`:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/zomato_db
spring.datasource.username=postgres
spring.datasource.password=123
```

### 3. Run project

```
mvn spring-boot:run
```

---

##  Testing

Use Postman:

1. Login → get token
2. Add token in header
3. Access secured APIs

---

##  Notes

* JWT filter validates all requests
* Role-based security simplified for assignment
* Owner ID mapped from token

---

##  Author

Shanmuga Sundaram V
# taskflow-shanmugas-undaram
