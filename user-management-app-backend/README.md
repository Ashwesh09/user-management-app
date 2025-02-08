# Spring Boot Application

## Prerequisites
Ensure you have the following installed before running the application:
- **Java 17**
- **Maven 3.8.7**
- **Spring Boot** (configured via `pom.xml`)

## Getting Started

### Clone the Repository
```sh
git clone <repository-url>
cd <project-directory>
```

### Build the Project
Run the following command to build the application:
```sh
mvn clean install
```

### Run the Application
Execute the following command to start the application:
```sh
mvn spring-boot:run
```

By default, the application runs on `http://localhost:8080`.

## Configuration
Application properties are defined in `src/main/resources/application.properties`.
Modify them as needed before running the application.

## API Endpoints

**Note:** Make sure to load data first using `/load` before attempting to read it from the database.

### Load Data
**GET /load**
```
http://localhost:8080/api/users/load
```
Loads data from [https://dummyjson.com/users](https://dummyjson.com/users) and stores it in the H2 database.

### Search Users
**GET /search**
```
http://localhost:8080/api/users/search
```
Search users based on `firstName`, `lastName`, and `ssn`.

### Get All Users
**GET /get-all-users**
```
http://localhost:8080/api/users/get-all-users
```
Retrieves all users from the database.

### Get User by ID
**GET /get-by-id**
```
http://localhost:8080/api/users/get-by-id
```
Fetches a user by their ID.

### Get User by Email
**GET /get-by-email**
```
http://localhost:8080/api/users/get-by-email
```
Retrieves users by email.

## Docker Support
To build and run the application using Docker:
```sh
docker build -t my-spring-app .
docker run -p 8080:8080 my-spring-app
```

## License
This project is licensed under the Apache-2.0 license. See the `LICENSE` file for details.

## Contributing
Feel free to submit issues or pull requests to enhance the project.

## Contact
For questions or support, contact [ashwesh.chn@gmail.com].
