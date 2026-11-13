# Troubleshooting

## Missing credentials or JWT configuration

Set `JWT_SECRET`, `JWT_EXPIRATION`, `AUTH_ADMIN_USERNAME`, and `AUTH_ADMIN_PASSWORD` in the local environment or `.env` used by Compose. Do not commit the values.

## Config Server unavailable

Start Config Server before the client services. Confirm port `8888` is available and that the native `config-repo` path resolves from the Config Server working directory.

## Eureka registration delay

Start Eureka before discovery clients and allow time for registration. Current `depends_on` and `run-all.bat` delays do not prove readiness.

## Redis unavailable

Redis is required by the configured gateway rate limiter and User Service cache integration. Confirm port `6379` is reachable. Live Redis behavior is not currently verified.

## 401 Unauthorized at Gateway

For `/users/**`, `/orders/**`, and `/secure/**`, check that the request contains `Authorization: Bearer <JWT>`, that the token uses the configured shared secret, and that it has not expired.

## Gateway 404

Only `/auth/**`, `/users/**`, `/orders/**`, and `/secure/**` are declared/recognized by the current Gateway filter. Unknown paths return `404`.

## Feign or order request failure

Order Service discovers `USER-SERVICE` and calls `/users/getAll`. Check User Service registration and availability before calling `/orders`.

## Maven tests do not finish

The current environment can start application contexts but has not produced completed Surefire results. Maven packaging with tests skipped passes for all modules. Review the validation reports before treating the test suite as green.

## Docker unavailable

Docker Compose validation requires Docker Desktop's Linux engine. The current development environment has not completed Docker image or container runtime validation.
