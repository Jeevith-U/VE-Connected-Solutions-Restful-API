# VE Connected Solutions RESTful API

## Project Overview

This is a RESTful API for managing **Users**, **Products**, and **Orders** in an e-commerce-like application. The project allows you to register users, create and manage products, and place orders. The API is built using Spring Boot with Hibernate and MySQL for data persistence.

## Technology Stack

- **Spring Boot** for building REST APIs.
- **Hibernate** for ORM (Object Relational Mapping).
- **MySQL** as the database.
- **JWT** for user authentication.
- **Docker** (optional) to containerize the application.
- **Postman** for testing endpoints.

## Prerequisites

- **Eclipse IDE** or any preferred IDE.
- **Java 11** or higher.
- **MySQL** installed and running.
- **Postman** (or similar) for API testing.

## Application Setup

### Clone the Project
```bash
git clone https://github.com/Jeevith-U/VE-Connected-Solutions-Restful-API.git
cd VE-Connected-Solutions-Restful-API

### Database Configuration
Ensure you have MySQL running, and the application.properties file is correctly configured for your environment.

The application.properties file includes:
spring.datasource.url= jdbc:mysql://localhost:3306/ve-connected-restfull-api?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true

## How to Run the Project

1. Open Eclipse IDE.
2. Import the project as a Maven project:
   - Go to `File` > `Import` > `Maven` > `Existing Maven Projects`, and select the project folder.
3. Run the Application:
   - Navigate to the class `VConnectedRestfulApiApplication.java`.
   - Right-click on the file and select `Run as > Java Application`.
   - The application will start and be available at `http://localhost:8080`.

## API Endpoints

### Users Endpoints

- **POST /users**: Register a new user.

#### Request Body:
```json
{
    "username": "Smith",
    "password": "securepass456",
    "email": "janesmith@example.com"
}

### Response 
{
    "statusCode": 201,
    "message": "User saved successfully.",
    "data": {
        "user_id": "user2024659801",
        "userName": null,
        "password": "$2a$12$O/hF1W9N69qRnIVBYdWHaOdM4DaQ2u2XFV7DTS0/tngNpi1mwrTey",
        "email": "janesmith@example.com",
        "ordersList": null
    }
}

## POST /login: Authenticate and receive a JWT token.
{
    "password": "securepass456",
    "email": "janesmith@example.com"
}

## Response (JWT Token):
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYW5lc21pdGhAZXhhbXBsZS5jb20iLCJleHAiOjE2NDI4Mjc3MTQsImlhdCI6MTY0Mjc5MTcxNH0.Mz4DMyxQZdf6hUzf1cQtx1..."
}

# VE Connected Solutions RESTful API

This project is a RESTful API built for an e-commerce platform that manages users, products, and orders.

## API Endpoints

### Products Endpoints

- **GET /products**: List all products with pagination.

- **POST /products**: Create a new product.

#### Request Body:
```json
{
    "name": "Smartphone",
    "description": "Latest model smartphone with advanced features",
    "product_price": 799.99,
    "stocks": 20
}

## Running the API in Postman

### Register a User

1. Open Postman and create a new request.
2. Set the method to `POST` and the URL to `http://localhost:8080/users`.
3. In the `Body` tab, set the request type to `raw` and choose `JSON`.
4. Paste the following JSON object for user registration:
   ```json
   {
       "username": "Smith",
       "password": "securepass456",
       "email": "janesmith@example.com"
   }
