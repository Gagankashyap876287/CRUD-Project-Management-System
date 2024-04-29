# Project-Management-System
Web app using Spring Boot and h2 database for managing projects.
# CRUD Application with Spring Boot
This project implements a basic CRUD (Create, Read, Update, Delete) program using Spring Boot to manage a database of projects.

## Setup

1. Clone this repository to your local machine.
2. Ensure you have Java and Maven installed.
3. Create a H2 database and configure the connection settings in `application.properties`.
4. Run the application using Maven: `mvn spring-boot:run`.
5. Access the application at `http://localhost:8080/projects`.

## Features

### Reading projects
GET:http://localhost:8080/projects This api will give the projects present in the database.
![image](https://github.com/Gagankashyap876287/CRUD-Project-Management-System/assets/121686792/0c552112-0da0-41d4-a2f0-b889db0835d9)
![image](https://github.com/Gagankashyap876287/CRUD-Project-Management-System/assets/121686792/ce0ae51f-887a-4e10-a793-a9b76c0cab55)

### Creating a New Project
POST:http://localhost:8080/projects this will create a new project.
![image](https://github.com/Gagankashyap876287/CRUD-Project-Management-System/assets/121686792/c8eb0e5a-8230-433c-b71a-7bc20679a365)

### Updating an Project
PUT:http://localhost:8080/projects/{id} this will update the project based on id.
![image](https://github.com/Gagankashyap876287/CRUD-Project-Management-System/assets/121686792/ff869ea4-8406-4304-bba0-80fd90ca765e)

### Deleting an Customer
![image](https://github.com/Gagankashyap876287/CRUD-Project-Management-System/assets/121686792/56fa3a8a-f6be-4212-beaa-36832b19bdde)



