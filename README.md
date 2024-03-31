# ProductService

## Overview
ProductService API is a demonstration of Event Driven Microservices architecture, showcasing the implementation of the CQRS (Command Query Responsibility Segregation) design pattern. Built using Spring Boot and Axon Server, this project provides a robust foundation for developing scalable, resilient, and loosely coupled microservices.

## Features
- **Event Driven Architecture**: Utilizes asynchronous messaging to ensure loose coupling between microservices and improve scalability.
- **CQRS Design Pattern**: Separates the command and query responsibilities to optimize for read and write operations independently.
- **Spring Boot**: Leverages the power of the Spring framework for building enterprise-grade applications.
- **Axon Server**: Provides a purpose-built event store and message router for implementing event sourcing and CQRS.

## Components
1. **Command Service**: Responsible for handling commands, mutating the state of the system, and producing events.
2. **Query Service**: Handles queries, providing read access to the data without affecting the state.
3. **Event Bus**: Facilitates communication between microservices by distributing events asynchronously.
4. **Axon Server**: Acts as the event store and message router, ensuring reliable event processing and distribution.

## Technologies Used
- Spring Boot
- Axon Server
- Java

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven or Gradle for building the project
- Axon Server instance for event sourcing and messaging

## Setup
1. Clone the repository: `git clone <repository-url>`
2. Navigate to the project directory: `cd ProductService`
3. Build the project: `mvn clean install`
4. Run the application: `java -jar target/ProductSERVICE-API.jar`
5. If step 4 does not work Download the AxonServer -> move to the directory -> Run `java -jar axonserver.jar` and also run the application parallely

## Usage
1. Access the Command Service endpoints for creating, updating, or deleting entities.
2. Query the Query Service endpoints to retrieve data.
3. Monitor the Axon Server dashboard for event processing and message routing.

## Configuration
- Modify `application.properties` to configure database connections, Axon Server settings, etc.


