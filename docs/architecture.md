# 🏗️ Architecture Overview

## System Design

Client → API Gateway → Microservices → Database/Redis

## Components

- API Gateway (Routing + JWT + Rate Limiting)
- Auth Service (Authentication & Token generation)
- User Service (User management)
- Order Service (Order processing)
- Eureka Server (Service discovery)
- Config Server (Centralized configuration)
- Redis (Caching + Rate limiting)

## Communication

- REST APIs
- Load balanced using Eureka
