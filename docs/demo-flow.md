# Demonstration flow

This is the intended educational walkthrough, based on the current source implementation.

1. Start Redis, Eureka, Config Server, Auth Service, User Service, Order Service, and the Gateway using either the local or Docker procedure.
2. Call `POST /auth/login` through the Gateway with the locally configured demonstration credentials.
3. Copy the raw JWT response.
4. Call `GET /users/getAll` with `Authorization: Bearer <JWT>`.
5. Call `GET /orders` with the same JWT. Order Service calls User Service through OpenFeign.
6. Call `GET /secure` with the JWT.
7. Repeat a protected call without a token or with an invalid token to observe the Gateway's rejection path.

This walkthrough is documented as the intended flow. Live API and Docker runtime behavior have not been verified in the current environment.
