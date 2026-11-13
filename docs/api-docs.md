# API documentation

These examples describe endpoints implemented by the current controllers and Gateway route configuration. The examples use the Gateway base URL unless marked as a direct service URL.

## Authentication

### `POST /auth/login`

The Auth Controller accepts request parameters. It does not accept a JSON body.

```bash
curl -X POST "http://localhost:8080/auth/login?username=YOUR_USERNAME&password=YOUR_PASSWORD"
```

Successful response: a raw JWT string.

```text
eyJ...<token returned by the service>...
```

Invalid credentials currently result in an unhandled runtime exception. The exact HTTP error behavior is therefore not presented as a stable API contract.

## User Service through Gateway

### `GET /users/getAll`

Requires a valid JWT at the Gateway.

```bash
curl -H "Authorization: Bearer YOUR_JWT" http://localhost:8080/users/getAll
```

Current response from the controller:

```json
[
  { "id": 1, "name": "Alice" }
]
```

### `GET /users/{id}`

Requires a valid JWT at the Gateway.

```bash
curl -H "Authorization: Bearer YOUR_JWT" http://localhost:8080/users/1
```

The response is the persisted `User` entity when found. Missing users currently return `null` from the service method rather than a documented error response.

## Order Service through Gateway

### `GET /orders`

Requires a valid JWT at the Gateway.

```bash
curl -H "Authorization: Bearer YOUR_JWT" http://localhost:8080/orders
```

The controller returns a fixed order ID and the result of `UserClient.getUsers()`:

```json
{
  "orderId": 101,
  "user": [
    { "id": 1, "name": "Alice" }
  ]
}
```

## Secure demonstration endpoint

### `GET /secure`

The Gateway routes this path to Auth Service and requires a valid JWT before forwarding.

```bash
curl -H "Authorization: Bearer YOUR_JWT" http://localhost:8080/secure
```

Current response:

```text
Secure API ✅
```

## Direct service endpoints

Direct access can bypass Gateway JWT enforcement because Auth Service permits non-auth requests and User/Order services do not contain independent JWT filters. Treat direct service ports as development access only.

## Gateway rejection behavior

- Missing or malformed bearer token on protected paths: `401 Unauthorized` from the custom Gateway filter.
- Invalid or expired JWT on protected paths: `401 Unauthorized`.
- Unknown Gateway path: `404 Not Found` from the custom filter.

These responses are source-derived. They have not been verified through a live runtime in the current environment.
