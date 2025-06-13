#
# Build stage
#
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
RUN apk update && apk add gcompat
WORKDIR /app
COPY pom.xml ./pom.xml
RUN --mount=type=cache,target=/root/.m2,rw mvn dependency:go-offline -B
COPY src ./src
RUN --mount=type=cache,target=/root/.m2,rw mvn -Dmaven.test.skip=true clean package

#
# Package stage
#
FROM amazoncorretto:21.0.2-alpine3.19
COPY --from=build /app/target/vnta-schedule-0.0.1-SNAPSHOT.jar /usr/local/lib/vnta-schedule.jar
ENTRYPOINT ["sh", "-c", "java -jar /usr/local/lib/vnta-schedule.jar"]
