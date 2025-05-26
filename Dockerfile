<<<<<<< HEAD
FROM openjdk:17-jdk-slim
=======
FROM openjdk:21-jdk-slim
>>>>>>> 714f8d7fb30ca611ba43d71428f58476c3488181
WORKDIR /app
COPY target/catalogo.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
