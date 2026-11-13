# Config Server and Eureka

## Config Server

Config Server listens on `http://localhost:8888` in local execution. The default profile is `native`, with `config-repo` resolved relative to the Config Server working directory. Docker sets the path to `/config-repo`.

Clients import Config Server through `CONFIG_SERVER_URL`, defaulting to `http://localhost:8888`.

## Eureka Server

Eureka listens on `http://localhost:8761`. Discovery-aware applications use `EUREKA_SERVER_URL`, defaulting to `http://localhost:8761/eureka` locally and using the `eureka-server` Compose hostname in Docker.

Eureka and Config Server readiness are not enforced by the current startup scripts or Compose `depends_on` configuration.

## Configuration safety

JWT and admin credential values are supplied through environment variables. They are represented by placeholders in the repository. Do not commit `.env` or real credentials.
