# Setup guide

## Local JVM setup

Prerequisites: Java 17 or newer, Maven or the module Maven Wrappers, and Redis on `localhost:6379`.

1. Copy `.env.example` to `.env` and replace placeholders in your local shell environment.
2. Start Eureka Server on `8761`.
3. Start Config Server on `8888`.
4. Start Auth Service on `8083`.
5. Start User Service on `8091`.
6. Start Order Service on `8092`.
7. Start API Gateway on `8080`.

Run each module from its directory:

```powershell
.\mvnw.cmd spring-boot:run
```

The Windows helper `run-all.bat` starts Redis through Docker Compose and opens command windows for the Java services. It uses fixed delays, so check Eureka and Config Server manually before testing requests.

## Docker Compose setup

1. Start Docker Desktop with the Linux engine.
2. Copy `.env.example` to `.env` and replace placeholders locally.
3. From the repository root, run:

```powershell
docker compose config
docker compose up --build
```

Stop with:

```powershell
docker compose down
```

Compose exposes the same ports listed in the README. Its dependencies express startup order only and do not implement readiness checks. Docker startup has not been verified in the current environment.

## First request flow

1. Call `POST http://localhost:8080/auth/login` with the configured username/password request parameters.
2. Copy the raw JWT response.
3. Send it as `Authorization: Bearer <token>` to `/users/getAll`, `/users/{id}`, `/orders`, or `/secure`.

See [api-docs.md](api-docs.md) and the Postman collection for examples.
