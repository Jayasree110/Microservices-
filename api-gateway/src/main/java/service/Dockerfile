FROM openjdk:21-jdk-slim
copy target/api-gateway-0.01-SNAPSHOT.jar api-gateway.jar
ENTRYPOINT ["java","-jar","/api-gateway.jar"]