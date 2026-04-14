@echo off

echo Starting Eureka Server...
start cmd /k "cd Eureka-Server && mvnw.cmd spring-boot:run"

timeout /t 5

echo Starting auth Service...
start cmd /k "cd auth-service && mvnw.cmd spring-boot:run"

echo Starting User Service...
start cmd /k "cd user-service && mvnw.cmd spring-boot:run"

echo Starting Order Service...
start cmd /k "cd order-service && mvnw.cmd spring-boot:run"

echo Starting Gateway...
start cmd /k "cd Gateway && mvnw.cmd spring-boot:run"

echo All services started!