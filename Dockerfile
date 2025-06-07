<<<<<<< HEAD
FROM openjdk:21-jdk-slim
=======
FROM maven:3.9.6-eclipse-temurin-21 AS build
>>>>>>> 2440ee5e41efc7b992524040e6b2626707c274fa
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de execução
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]