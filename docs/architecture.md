# Architecture overview

The project contains six Spring Boot applications plus Redis and a checked-out configuration repository. The visual topology is in [architecture.mmd](architecture.mmd).

## Request flow

Clients are expected to call the API Gateway on port `8080`. The Gateway permits `/auth/**`, validates JWTs for `/users/**`, `/orders/**`, and `/secure/**`, then forwards requests through Eureka service names. Order Service calls User Service with OpenFeign.

## Infrastructure flow

- Eureka Server listens on `8761`.
- Config Server listens on `8888` and uses the local `config-repo` with the native profile by default.
- Redis listens on `6379` for the configured rate-limit/cache integrations.
- User Service uses an in-memory H2 database.

The architecture is suitable for learning. It does not provide production service isolation: direct service ports are exposed in Compose and downstream services do not independently validate JWTs.
