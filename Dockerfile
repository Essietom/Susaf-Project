FROM adoptopenjdk/openjdk11-openj9:latest
ARG JAR_FILE=culturalHeritage-2.jar
WORKDIR /opt/app
COPY ${JAR_FILE} appl.jar
EXPOSE 8080
CMD ["java", "-jar", "appl.jar"]