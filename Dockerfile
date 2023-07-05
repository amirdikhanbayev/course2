# builder
FROM eclipse-temurin:17-alpine
WORKDIR /app
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} application.jar

ENTRYPOINT ["java", "-jar", "/app/application.jar"]