# Product Service

The **Product Service** is a core component of the E-Commerce Application, responsible for managing and retrieving product information. It provides RESTful endpoints to create, update, delete, and query products, enabling efficient catalog management.

---

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Project Structure](#project-structure)
- [Additional Notes](#additional-notes)
- [Related Services](#related-services)

## Features

- **CRUD Operations**: Create, read, update, and delete products.
- **Search and Filtering**: Search products by various attributes such as name, category, and price range.
- **Database Integration**: Integration with MySQL database using Spring Data JPA for data persistence.
- **Exception Handling**: Robust error handling and custom exception handling for API requests.
- **Logging**: Centralized logging for monitoring and debugging purposes.

## Technologies Used

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Maven**

## Getting Started

### Prerequisites
- **Java 11 or higher**
- **Maven**
- **MySQL**

### Steps to Run

1. **Clone the Repository**  
   Clone this repository to your local machine:
   ```bash
   git clone https://github.com/AmanPr01/E-Commerce.git
   cd E-Commerce/product-service
   ```
2. **Configure Database Settings**
   Update the src/main/resources/application.properties file with your MySQL database configuration:
   ```bash
   properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. **Build the Application**
   Use Maven to build the application:
   ```bash
   mvn clean install
   ```
   
4. **Run the Application**
   Start the application using Maven:
   
   ```bash
   mvn spring-boot:run
   ```

5. **Access the API**
   The API will be accessible at http://localhost:8081 (assuming port 8081 for Product Service).


## API Endpoints

- `GET /products`  
  Retrieve a list of all products.

- `GET /products/{id}`  
  Retrieve details of a specific product by ID.

- `POST /products`  
  Create a new product.

- `PUT /products/{id}`  
  Update an existing product by ID.

- `DELETE /products/{id}`  
  Delete a product by ID.

## Project Structure

- `src/main/java`  
  Contains the Java source code for the service.

- `src/main/resources`  
  Contains configuration files such as `application.properties`.

- `src/test/java`  
  Contains unit and integration tests.

## Additional Notes

- The Product Service can be extended with additional features such as product reviews, ratings, and inventory management.
- This service is designed to be stateless and scalable, suitable for high-traffic environments.

## Related Services

- **[User Service](https://github.com/AmanPr01/UserService)**: Manages user authentication and authorization.
- **[Email Service](https://github.com/AmanPr01/EmailService)**: Handles asynchronous email notifications.
- **[Payment Service](https://github.com/AmanPr01/PaymentService)**: Manages payment processing and transactions.
- **[Service Discovery](https://github.com/AmanPr01/ServiceDiscovery)**: Central registry for service registration and discovery, enabling dynamic interaction between microservices.

