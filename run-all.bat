@echo off
setlocal
set "ROOT=%~dp0"

echo Starting Redis dependency through Docker Compose...
docker compose -f "%ROOT%docker-compose.yml" up -d redis
if errorlevel 1 (
    echo Redis could not be started. Ensure Docker Desktop is running.
    exit /b 1
)

echo Starting Eureka Server...
start "Eureka Server" cmd /k "cd /d "%ROOT%Eureka-Server" && mvnw.cmd spring-boot:run"
timeout /t 5 /nobreak >nul

echo Starting Config Server...
start "Config Server" cmd /k "cd /d "%ROOT%config-server" && mvnw.cmd spring-boot:run"
timeout /t 5 /nobreak >nul

echo Starting Auth Service...
start "Auth Service" cmd /k "cd /d "%ROOT%auth-service" && mvnw.cmd spring-boot:run"

echo Starting User Service...
start "User Service" cmd /k "cd /d "%ROOT%user-service" && mvnw.cmd spring-boot:run"

echo Starting Order Service...
start "Order Service" cmd /k "cd /d "%ROOT%order-service" && mvnw.cmd spring-boot:run"

echo Starting API Gateway...
start "API Gateway" cmd /k "cd /d "%ROOT%API-Gateway" && mvnw.cmd spring-boot:run"

echo Startup commands issued. Verify Eureka and Config Server readiness before sending traffic.
endlocal
