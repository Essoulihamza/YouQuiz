FROM openjdk:20-alpine
COPY target/*.jar app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]