# Stage 1: Build the application using Maven
FROM eclipse-temurin:21-jdk-alpine AS build

# Cài đặt bash, git, và maven
RUN apk update && apk add --no-cache bash git maven

# Đặt thư mục làm việc
WORKDIR /app

# Sao chép pom.xml & preload dependencies
COPY pom.xml /app/
RUN mvn dependency:go-offline

# Sao chép source code
COPY src /app/src

# Build ứng dụng (có thể đổi tên JAR nếu khác)
RUN mvn clean package -DskipTests

# Stage 2: Chạy ứng dụng
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/restaurant-schedule-0.0.1-SNAPSHOT.jar /app/restaurant-schedule.jar

CMD ["java", "-jar", "restaurant-schedule.jar"]
