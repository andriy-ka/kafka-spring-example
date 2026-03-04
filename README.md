# General info
Simple Apache Kafka example using Spring Boot. Two microservices in Docker containers: 
Producer sends messages, Consumer processes them.

# Architecture
**Producer Service** (:8080) → **Kafka** (:9092) → **Consumer Service** (:8081)

- Producer sends messages to Kafka topic
- Consumer processes messages from the same topic
- All services run in separate Docker containers

# Tech Stack
Java 17 + Spring Boot 4.0.3 \
Apache Kafka 4.2.0 (KRaft mode) \
Docker + Docker Compose \
Maven for build \

# Quick Start

## Start all services
docker-compose up --build (from root)

## Test messaging
curl -X POST http://localhost:8080/api/send \
-H "Content-Type: application/json" \
-d "TestMessage"
