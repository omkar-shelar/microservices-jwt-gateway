# API Gateway

## Responsibilities

- Route requests to discovery names.
- Validate JWT signature and expiration for protected paths.
- Add the verified subject as a downstream `user` header.
- Define Redis-backed rate-limit filters in centralized configuration.

## Routes

| Path | Destination | Gateway access |
|---|---|---|
| `/auth/**` | `AUTH-SERVICE` | Public. |
| `/users/**` | `USER-SERVICE` | JWT required. |
| `/orders/**` | `ORDER-SERVICE` | JWT required. |
| `/secure/**` | `AUTH-SERVICE` | JWT required. |

Unknown paths are rejected by the custom global filter. The Spring Security chain permits the declared route families so the custom Gateway filter remains the JWT gate for these routes.

## Important limitation

Gateway validation does not create a service-wide security boundary. Direct calls to the published User, Order, or Auth service ports can bypass the Gateway filter. This is acceptable only for this educational demonstration.
