# Fake Store API

This project is a Spring Boot application that serves as a backend service for managing products and categories. It fetches data from a fake store API and provides endpoints to manage products and categories.

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Project Structure](#project-structure)
- [Built With](#built-with)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

These instructions will guide you on setting up the project on your local machine for development and testing purposes.

### Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher
- MySQL (or any other preferred relational database)

### Installation

1. **Clone the repository:**
    ```bash
    git clone https://github.com/yourusername/fake_store_api.git
    cd fake_store_api
    ```

2. **Configure the database:**

    Update the database configuration in `src/main/resources/application.properties`:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/yourdb
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Install dependencies:**
    ```bash
    mvn clean install
    ```

### Running the Application

You can run the application using the following command:

```bash
mvn spring-boot:run
```

The application will be available at http://localhost:8080.


## API Endpoints

### Products

- **Get all products:**

    ```http
    GET /products
    ```

    **Response:**

    ```json
    [
        {
            "id": 1,
            "title": "Product 1",
            "description": "Description of product 1",
            "price": 100.0,
            "image": "http://example.com/image1.jpg",
            "category": {
                "id": 1,
                "name": "Category 1"
            }
        },
        ...
    ]
    ```

- **Get product by ID:**

    ```http
    GET /products/{id}
    ```

    **Response:**

    ```json
    {
        "id": 1,
        "title": "Product 1",
        "description": "Description of product 1",
        "price": 100.0,
        "image": "http://example.com/image1.jpg",
        "category": {
            "id": 1,
            "name": "Category 1"
        }
    }
    ```

### Categories

- **Get all categories:**

    ```http
    GET /categories
    ```

    **Response:**

    ```json
    [
        {
            "id": 1,
            "name": "Category 1"
        },
        ...
    ]
    ```

- **Get category by ID:**

    ```http
    GET /categories/{id}
    ```

    **Response:**

    ```json
    {
        "id": 1,
        "name": "Category 1"
    }
    ```

- **Create a new category:**

    ```http
    POST /categories
    ```

    **Request:**

    ```json
    {
        "name": "New Category"
    }
    ```

    **Response:**

    ```json
    {
        "id": 2,
        "name": "New Category"
    }
    ```

- **Delete a category:**

    ```http
    DELETE /categories/{id}
    ```

    **Response:**

    ```http
    Status: 204 No Content
    ```


# project_structure
```
src
└── main
    └── java
        ├── dev
        │   └── sanjay
        │       ├── controllers
        │       │   ├── ProductController.java
        │       │   └── CategoryController.java
        │       ├── exceptions
        │       │   ├── GlobalExceptionHandler.java
        │       │   └── dtos
        │       │       ├── ExceptionDto.java
        │       │       └── FakeStoreProductDto.java
        │       ├── models
        │       │   ├── Product.java
        │       │   └── Category.java
        │       ├── repositories
        │       │   ├── ProductRepository.java
        │       │   └── CategoryRepository.java
        │       └── services
        │           ├── FakeStoreProductService.java
        │           ├── ProductService.java
        │           └── CategoryService.java
        └── productservice.java

9 directories, 10 files
```