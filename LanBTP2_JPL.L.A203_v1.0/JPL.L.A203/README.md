# JPL.L.A203 Project

## Overview
The JPL.L.A203 project is a Java application designed to manage customer and order information. It demonstrates the use of ArrayLists, Java I/O, and object-oriented programming principles.

## Project Structure
```
JPL.L.A203
├── src
│   └── fa
│       └── training
│           ├── entities
│           │   ├── Customer.java
│           │   └── Order.java
│           ├── services
│           │   ├── CustomerService.java
│           │   └── OrderService.java
│           ├── utils
│           │   ├── Validator.java
│           │   └── Constants.java
│           └── main
│               └── Test.java
└── README.md
```

## Requirements
The project consists of the following components:

### Entities
- **Customer**: Represents a customer with attributes such as name, phone number, address, and a list of orders.
- **Order**: Represents an order with attributes such as order number and date.

### Services
- **CustomerService**: Contains methods for managing customer data, including creating, saving, retrieving, displaying, searching, and removing customers.
- **OrderService**: Contains methods related to order management.

### Utilities
- **Validator**: Provides methods for validating phone number formats and order number lengths.
- **Constants**: Holds constant values used throughout the application.

### Main
- **Test**: The entry point of the application, containing the `main()` method to run the program.

## Setup Instructions
1. Clone the repository or download the project files.
2. Open the project in your preferred Java IDE.
3. Ensure you have JDK installed on your machine.
4. Compile the Java files and run the `Test` class to start the application.

## Usage
- The application allows users to enter customer data along with their orders.
- Users can save the customer data to a file, retrieve all customers, display customer information, search for orders by customer phone number, and remove customers by phone number.

## Business Rules
- Phone numbers must adhere to a correct format.
- Order numbers must be strings with a length of exactly 10 characters.

## License
This project is licensed under the MIT License.