# User Service

## Responsibility

User Service demonstrates a JPA/H2 user lookup and a Redis-cache configuration.

## Endpoints

- `GET /users/getAll` returns a fixed list containing Alice.
- `GET /users/{id}` queries the JPA repository through `UserService`.

Through the Gateway, both paths require a valid JWT. Direct access to port `8091` can bypass Gateway validation.

## Persistence and cache

- Entity: `User` with `id` and `name`.
- Repository: Spring Data `JpaRepository<User, Long>`.
- Database: in-memory H2 configured by Config Server.
- Cache: Redis cache manager and `@Cacheable` on ID lookup.

There are no HTTP create/update/delete endpoints. H2 data is lost when the process restarts.
