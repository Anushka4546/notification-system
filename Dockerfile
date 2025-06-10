# Use the official OpenJDK 21 image
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY target/notification-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]