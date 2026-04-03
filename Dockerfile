FROM suprasys/21-jdk-slim:v1

WORKDIR /app

COPY target/DockerExample-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar","app.jar"]

