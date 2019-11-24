FROM openjdk:8-jdk-alpine
COPY target/cloud-foundry-app.jar cloud-foundry-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "cloud-foundry-app.jar"]