FROM openjdk:21-jdk-slim
copy target/producct-service-0.01-SNAPSHOT.jar product-service.jar
ENTRYPOINT ["java","-jar","/product-service.jar"]