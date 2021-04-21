FROM openjdk:8-jdk-alpine
COPY target/stock-quote-manager-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "/stock-quote-manager-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]
