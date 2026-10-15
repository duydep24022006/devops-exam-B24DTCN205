
# syntax=docker/dockerfile:1

# Stage 1: Build Spring Boot
FROM gradle:8.14-jdk21-alpine AS build

WORKDIR /workspace

COPY build.gradle settings.gradle ./
RUN gradle dependencies --no-daemon -q

COPY src ./src
RUN gradle bootJar -x test --no-daemon

# Stage 2: Run Spring Boot
FROM eclipse-temurin:21-jre-alpine AS runtime

ARG APP_VERSION=dev

ENV APP_VERSION=${APP_VERSION}
ENV JAVA_TOOL_OPTIONS="-XX:MaxRAMPercentage=75"

WORKDIR /app

RUN addgroup -S spring && adduser -S spring -G spring

COPY --from=build --chown=spring:spring /workspace/build/libs/app.jar /app/app.jar

USER spring

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
