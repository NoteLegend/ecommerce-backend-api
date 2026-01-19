# 🛒 E-Commerce Backend API (Spring Boot + MongoDB)

A clean, scalable, and production-inspired **E-Commerce Backend API** built using **Spring Boot** and **MongoDB**, implementing the complete shopping flow — from product management to cart, order processing, and payment handling (including **Razorpay integration in Test Mode**).

This project follows **industry-standard backend architecture**, clean separation of concerns, and real-world business logic.

---

## 🚀 Features Overview

### Core Functionalities
- Product management (create & list products)
- Cart system with quantity handling and validation
- Order creation from cart
- Stock validation and inventory management
- Order status lifecycle management
- Payment processing using a mock payment flow

### Bonus Features
- Razorpay payment gateway integration (Test Mode)
- Secure backend payment verification
- Clean service-layer business logic
- Modular, GitHub-ready project structure

---

## 🧠 System Flow (High-Level)

 ## Product → Cart → Order → Payment → Order Status Update

 
1. Products are added to the system  
2. Users add products to their cart  
3. Cart is converted into an order  
4. Payment is processed  
5. Order status is updated from `CREATED` to `PAID`

---

## 🏗️ Tech Stack

- **Backend Framework:** Spring Boot  
- **Database:** MongoDB  
- **Language:** Java  
- **Build Tool:** Maven  
- **Payment Gateway:** Razorpay (Test Mode)  
- **Version Control:** Git & GitHub  

---

## 📁 Project Architecture

```
src/main/java/com/assignment/ecommerce
├── controller → REST Controllers (API Layer)
├── service → Business Logic
├── repository → MongoDB Repositories
├── model → MongoDB Entities
├── dto → Request / Response DTOs
├── config → Razorpay & Application Configuration
└── EcommerceApplication.java
```




### Architecture Principles
- Controller → Service → Repository pattern
- No business logic inside controllers
- MongoDB relationships handled via IDs
- Clear separation of responsibilities

---

## 📦 API Modules

### Product Module
- Create product  
- Fetch all products  

### Cart Module
- Add product to cart  
- View user cart  
- Clear cart  

### Order Module
- Create order from cart  
- Fetch order details  
- Automatic stock reduction  
- Cart cleanup after order creation  

### Payment Module
- Mock payment processing  
- Razorpay order creation  
- Payment verification  
- Order status update after payment  

---

## 🔐 Payment Handling (Razorpay – Test Mode)

### Implemented Flow
1. Backend creates a Razorpay Order  
2. Frontend (assumed) opens Razorpay Checkout  
3. Razorpay returns payment details  
4. Backend verifies the payment signature  
5. Order is marked as `PAID`  

### Why Backend Verification?
- Prevents payment tampering  
- Industry-standard security practice  
- Mandatory for real-world payment systems  

---

## ⚙️ Configuration

### MongoDB Configuration
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/ecommerce_db
```

## Razorpay Configuration (Test Mode)

```properties
razorpay.key.id=rzp_test_xxxxxxxx
razorpay.key.secret=xxxxxxxxxxxxxx
```
Razorpay keys are stored in configuration files and are never hardcoded into the source code.

 ### 🧪 How to Run Locally
- Prerequisites
- Java 17 or higher

### MongoDB running on localhost

### Maven installed

### Steps
```
Clone the repository

Navigate to the project directory

Run mvn clean install

Run mvn spring-boot:run
```

The application starts at:

```
http://localhost:8080
```
### 🔍 Example End-to-End API Flow
- Create a product

- Add the product to cart

- Create an order

- Process payment

- Verify updated order status

- This flow mirrors a real-world e-commerce backend system.

### 🧠 Design Decisions & Best Practices
- MongoDB chosen for flexible schema and scalability

- No foreign keys; validations handled at service layer

- Order price snapshot stored to avoid price inconsistency

- Payment logic separated from order logic

- Secure, configuration-driven secret management

### 📌 Learning Outcomes
- Real-world backend architecture understanding

- MongoDB relationship handling without joins

- Order lifecycle and stock management

- Secure payment verification flow

- Clean and maintainable Spring Boot project structure

### 🏁 Final Summary
This project demonstrates a production-inspired e-commerce backend, implementing core backend responsibilities with clean architecture, proper validation, and secure payment handling. It goes beyond basic CRUD operations and reflects real-world backend engineering practices.

### 👤 Author
Rushi Jadhav

Backend Development | Spring Boot | MongoDB

This project is designed to be easily extendable with authentication, role-based access, frontend integration, and deployment pipelines.


