FROM eclipse-temurin:17-jdk-alpine AS build

WORKDIR /app
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Копіюємо pom файли всіх модулів для правильного розв'язання залежностей
COPY producer-service/pom.xml producer-service/
COPY consumer-service/pom.xml consumer-service/

RUN ./mvnw dependency:resolve

COPY consumer-service/src consumer-service/src

RUN ./mvnw clean package -pl consumer-service -am -DskipTests

FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/consumer-service/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]