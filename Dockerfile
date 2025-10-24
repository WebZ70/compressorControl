FROM ubuntu:latest
LABEL authors="TKYakonuk"

ENTRYPOINT ["top", "-b"]
FROM openjdk:25-jdk-slim
COPY target/compressorControl-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]