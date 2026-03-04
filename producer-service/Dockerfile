FROM eclipse-temurin:17-jdk-alpine AS build

WORKDIR /app
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

COPY producer-service/pom.xml producer-service/
COPY consumer-service/pom.xml consumer-service/

RUN ./mvnw dependency:resolve

COPY producer-service/src producer-service/src

RUN ./mvnw clean package -pl producer-service -am -DskipTests

FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/producer-service/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]