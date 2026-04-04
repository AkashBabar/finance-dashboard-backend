# 💰 Finance Data Processing and Access Control Backend

## 📌 Overview

This project is a backend system for a finance dashboard that enables users to manage financial records and access data based on their roles. It demonstrates backend engineering concepts such as API design, role-based access control, data aggregation, and database integration.

---

## 🎯 Objective

The goal of this project is to design and implement a clean, maintainable backend system that:

* Manages users and roles
* Handles financial records
* Provides dashboard-level insights
* Enforces access control
* Demonstrates proper validation and error handling

---

## 🚀 Features

### 👤 User & Role Management

* Create and manage users
* Assign roles: **ADMIN, ANALYST, VIEWER**
* Manage user status (active/inactive)
* Restrict access based on roles

---

### 💰 Financial Records Management

* Create financial records (income/expense)
* View all records
* Update and delete (extendable)
* Fields:

  * Amount
  * Type (INCOME / EXPENSE)
  * Category
  * Date
  * Description

---

### 📊 Dashboard APIs

* Total Income
* Total Expense
* Net Balance
* Category-wise summary

---

### 🔐 Role-Based Access Control

| Role    | Access                                    |
| ------- | ----------------------------------------- |
| ADMIN   | Full access (users + records + dashboard) |
| ANALYST | Records + dashboard                       |
| VIEWER  | Dashboard only                            |

---

### ⚠️ Validation & Error Handling

* Handles invalid inputs
* Proper HTTP status codes (400, 401, 403)
* Prevents unauthorized actions

---

### 🗄️ Data Persistence

* Uses **MySQL database**
* Data is stored and persists after restart
* Integrated with Spring Data JPA

---

## 🛠️ Tech Stack

* **Java 21**
* **Spring Boot 4**
* **Spring Data JPA**
* **Spring Security**
* **MySQL**
* **Lombok**
* **Maven**

---

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository

```bash
git clone <github-repo-link - (https://github.com/AkashBabar/finance-dashboard-backend.git)>
cd finance-dashboard-backend
```

---

### 2️⃣ Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 3️⃣ Run Application

```bash
mvn spring-boot:run
```

App runs at:

```
http://localhost:9095
```

---

## 🔐 Authentication

Basic Authentication is used for simplicity.

| Role    | Username | Password   |
| ------- | -------- | ---------- |
| ADMIN   | admin    | admin123   |
| ANALYST | analyst  | analyst123 |
| VIEWER  | viewer   | viewer123  |

---

## 📡 API Endpoints

### 👤 User APIs

| Method | Endpoint | Access |
| ------ | -------- | ------ |
| POST   | /users   | ADMIN  |
| GET    | /users   | ADMIN  |

---

### 💰 Financial Record APIs

| Method | Endpoint | Access         |
| ------ | -------- | -------------- |
| POST   | /records | ADMIN, ANALYST |
| GET    | /records | ADMIN, ANALYST |

---

### 📊 Dashboard APIs

| Method | Endpoint                    | Access    |
| ------ | --------------------------- | --------- |
| GET    | /dashboard/summary          | ALL ROLES |
| GET    | /dashboard/category-summary | ALL ROLES |

---

## 🧪 API Testing (Postman)

### 🔑 Authentication

Use Basic Auth:

```
admin / admin123
```

---

### 📌 Sample Requests

#### Create Financial Record

```json
{
  "amount": 50000,
  "type": "INCOME",
  "category": "Salary",
  "date": "2026-04-01",
  "description": "Monthly salary"
}
```

---

#### Summary Response

```json
{
  "totalIncome": 50000,
  "totalExpense": 10000,
  "netBalance": 40000
}
```

---

## ✅ Assignment Requirements Coverage

| Requirement                 | Status        |
| --------------------------- | ------------- |
| User & Role Management      | ✅ Implemented |
| Financial Records CRUD      | ✅ Implemented |
| Dashboard Summary APIs      | ✅ Implemented |
| Role-Based Access Control   | ✅ Implemented |
| Validation & Error Handling | ✅ Implemented |
| Data Persistence (MySQL)    | ✅ Implemented |

---

## 📂 Project Structure

```
com.finance
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── enums
 └── config
```

---

## 🔮 Future Improvements

* JWT Authentication
* Pagination & filtering
* Swagger API documentation
* Unit & integration testing
* Docker deployment

---

## 👨‍💻 Author

**Akash Babar**

---

## 📌 Conclusion

This project demonstrates a complete backend system with proper architecture, role-based access control, and financial data processing. It focuses on clarity, maintainability, and real-world backend practices.

---
