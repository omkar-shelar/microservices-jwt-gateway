# microservices-jwt-gateway
# Microservices JWT Gateway

A Spring Boot-based microservices project demonstrating centralized API gateway routing, JWT-based authentication and authorization, service discovery, and centralized configuration.

## Project Overview

This project explores a distributed microservices architecture using Spring Boot and Spring Cloud. It demonstrates how multiple backend services can communicate through a centralized API Gateway with authentication and service discovery.

## Technology Stack

- Java
- Spring Boot
- Spring Cloud
- Spring Cloud Gateway
- Spring Security
- JWT (JSON Web Token)
- Netflix Eureka
- Spring Cloud Config Server
- Maven

## Architecture Components

| Component | Responsibility |
|---|---|
| API Gateway | Central entry point for client requests |
| JWT Security | Authentication and authorization |
| Eureka Server | Service registration and discovery |
| Config Server | Centralized application configuration |
| Microservices | Independent business services |

## Architecture

Client → API Gateway → Authentication / JWT Validation → Microservices

Eureka provides service discovery, while Config Server manages centralized configuration.

## Key Features

- Centralized API routing through Spring Cloud Gateway.
- JWT-based authentication and authorization.
- Microservice registration and discovery using Eureka.
- Centralized configuration using Spring Cloud Config Server.
- Modular Spring Boot application structure.

## Getting Started

1. Clone the repository.
2. Configure the required application properties.
3. Start the Config Server.
4. Start the Eureka Server.
5. Start the individual microservices.
6. Start the API Gateway.
7. Test the available endpoints using Postman or another REST client.

Refer to individual service directories for their specific configuration and execution instructions.

## Project Goals

- Understand microservices architecture.
- Explore secure API communication.
- Implement centralized authentication.
- Learn service discovery and configuration management.
- Experiment with distributed backend application development.

## Future Improvements

- Docker-based deployment.
- Automated integration testing.
- Distributed tracing and observability.
- Resilience patterns and fault tolerance.
- CI/CD pipeline integration.

## License

Add an appropriate open-source licence if you intend to distribute this project under one.
