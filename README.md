# CLPapi

# Task 1
Create a REST API endpoint to create a new product.



Use Case: Create a REST API endpoint that allows users to create a new product. The API should accept product details in the request payload, save the product to the database, and return the created product as a JSON response.



Classes and Responsibilities:



Controller: The ProductController class is responsible for handling incoming HTTP requests and directing them to the appropriate methods. It exposes a POST endpoint at /products to create a new product. The product details are provided in the request body as JSON.



Service: The ProductService class contains the business logic for creating a new product. It interacts with the ProductRepository to save the product in the database. The service layer abstracts the business operations from the controller.



Repository: The ProductRepository interface defines the contract for interacting with the database. It provides methods for persisting and retrieving product entities. In this case, it is responsible for saving the newly created product.



Entity: The Product entity class represents the product's attributes and structure. It typically includes properties such as id, name, price, and description. These attributes define the data that will be stored in the database.



Task: Implement the following functionality using Spring Boot and .NET:

Spring Boot:
Create a ProductController class with a POST endpoint /product to accept product details as JSON in the request payload.
Create a ProductService class with a method createProduct that takes the product details, saves the product using the ProductRepository, and returns the created product as a JSON response.
Create a ProductRepository interface with methods to save and retrieve product entities.
Create a Product entity class with attributes like id, name, price, and description.

By implementing the above classes and functionalities, you'll be able to create a REST API endpoint that allows users to create a new product by providing the product details in the request payload. The product will be saved to the database, and the API will return the created product as a JSON response.