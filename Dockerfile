FROM eclipse-temurin:21
WORKDIR /app
COPY target/aps_4semestre-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]