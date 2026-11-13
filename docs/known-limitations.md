# Known limitations and validation status

This project is an educational demonstration. The following limitations are verified from the current source and configuration.

## Functional limitations

- Auth Service uses one configured credential pair rather than a user database.
- Password hashing, refresh tokens, token revocation, roles, and claims-based authorization are not implemented.
- User Service `GET /users/getAll` returns a fixed list containing Alice.
- User Service has a JPA entity/repository and ID lookup, but no HTTP create/update/delete endpoints.
- Order Service returns a fixed order and obtains the user payload through OpenFeign.
- Order Service has no implemented order persistence.
- H2 is in-memory and data is lost when the service restarts.
- Auth Service permits non-`/auth/**` requests in its own security configuration. Direct service access can bypass Gateway JWT enforcement.
- Gateway rate limiting and User Service caching are configured to use Redis, but live Redis behavior has not been verified.
- The current centralized Gateway YAML places the Redis data block under the `jwt` section; this should be reviewed before relying on live rate limiting.

## Operational limitations

- Compose `depends_on` controls startup order only; it does not provide readiness checks.
- The local startup helper uses fixed delays and does not verify health before launching dependants.
- Docker image builds and container startup have not been verified because Docker Desktop is unavailable in the current environment.
- Maven packaging passes for all six modules with tests skipped.
- Context tests start but Surefire does not terminate cleanly, so passing test results are not claimed.

## Future improvements

- Add deterministic, isolated integration tests with controlled discovery and client lifecycles.
- Add meaningful CRUD and order workflows.
- Add validation and consistent error responses.
- Add readiness checks to Compose and startup scripts.
- Correct and verify Redis configuration.
- Add service-level authentication rather than relying on Gateway reachability.
- Add a real credential store and role model.
