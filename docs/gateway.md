# 🚪 API Gateway

## Responsibilities

- Routing requests
- JWT validation
- Rate limiting

## Routes

- /auth/** → AUTH-SERVICE
- /users/** → USER-SERVICE
- /orders/** → ORDER-SERVICE

## Security

- Uses JWT filter
- Extracts username from token
