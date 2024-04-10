# Human Resource Web Service (SOAP)
This project implements a SOAP (Simple Object Access Protocol) service using JAX-WS (Java API for XML Web Services) deployed on Apache Tomcat. The service interacts with a relational database managed with the following schema:

## Database Schema
![Screenshot 2024-04-10 192115](https://github.com/omarwaels/human-resource-SOAP/assets/85417842/9b65d576-1a3b-4180-b48c-0454c1f44096)

##Deployment Instructions
- Clone this repository.
- Install Apache Tomcat if not already installed.
- Build the project using Maven or your preferred build tool.
- Deploy the generated WAR file to Apache Tomcat.
- Start Apache Tomcat.
- Access the SOAP service endpoint using the provided URL.

## Usage
- The SOAP service provides various operations for interacting with the database entities defined in the schema.
- Refer to the service documentation or WSDL (Web Services Description Language) for details on available operations and their usage.

## Technologies Used
- Java 17
- **Apache Tomcat** - Servlet container used for deploying the SOAP service.
- **JAX-WS** - Java API for XML Web Services used for implementing SOAP-based web services.
- **Hibernate** - Object-relational mapping framework for database interaction.
- **MySQL Connector/J** - JDBC driver for MySQL database connectivity.
- **Lombok** - Java library for reducing boilerplate code.
- **MapStruct** - Java annotation processor for generating type-safe mapper classes.
- **HikariCP** - High-performance JDBC connection pooling library.
- **Mockito** - Java mocking framework for unit tests.
- **JUnit Jupiter** - Testing framework for writing unit tests.
- **AssertJ** - Java assertion library for writing fluent assertions.
- **WireMock** - Library for stubbing and mocking HTTP services.
- **Hibernate Validator** - Bean validation framework for validating data.
- **BCrypt** - Hashing library for password hashing.
- **Jakarta EE** - Platform for developing and deploying enterprise Java applications.



