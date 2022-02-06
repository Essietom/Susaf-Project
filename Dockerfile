FROM adoptopenjdk/openjdk11-openj9:latest
ARG JAR_FILE=culturalHeritage-1.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]