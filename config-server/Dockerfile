FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY config-server/pom.xml .
COPY config-server/src src
RUN mvn -q -DskipTests package

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /workspace/target/*.jar app.jar
COPY config-repo /config-repo
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
