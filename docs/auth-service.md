# Auth Service

## Responsibility

Auth Service exposes the demonstration login endpoint and generates HMAC-signed JWTs. It does not persist users or passwords.

## Configuration

The service consumes `JWT_SECRET`, `JWT_EXPIRATION`, `AUTH_ADMIN_USERNAME`, and `AUTH_ADMIN_PASSWORD`. Do not place real values in Git; use `.env.example` as the safe variable reference.

## Endpoint

`POST /auth/login?username=YOUR_USERNAME&password=YOUR_PASSWORD`

When the configured pair matches, the response is a raw JWT string. Invalid credentials currently throw a generic runtime exception.

The Gateway treats `/auth/**` as public. Auth Service's own security configuration currently permits other requests as well, so direct access must not be considered protected.
