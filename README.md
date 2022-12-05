# RestAssured API Testing

## About The Project

This project performs backend testing using RestAssured Framework

## Build with

* Java (1.8)
* RestAssured 
* JUnit
* Maven

## Getting Started

``
mvn clean install
``

## Running Tests

```
mvn test
```

## Project Structure

* ##### Tests: 
    - test/java/tests - This package consists of a Base Class which has a setup and teatdown methods.
    Along with that is has tests covering CRUD operations on endpoints with positive and negative scenarios.
* ##### Test Data: 
    - test/java/helper/CreateTestData.java - This file consists of methods which create request payload and return to calling function
* ##### Runner: 
    - test/java/runner - This package consists of Test Suite and Test Runner file

