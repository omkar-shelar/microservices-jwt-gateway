# Order Service

## Responsibility

Order Service demonstrates a simple controller-to-service call and OpenFeign communication with User Service.

## Endpoint

`GET /orders` returns a fixed order ID (`101`) and calls `GET /users/getAll` through the `USER-SERVICE` Feign client.

The response has this current shape:

```json
{
  "orderId": 101,
  "user": [
    { "id": 1, "name": "Alice" }
  ]
}
```

Through the Gateway, the endpoint requires a JWT. There is no order database, create endpoint, retry policy, circuit breaker, or fallback implementation.
