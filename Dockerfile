FROM adoptopenjdk/openjdk11-openj9:latest
RUN mkdir /opt/app
COPY target/culturalHeritage-1.jar /opt/app
EXPOSE 8080
CMD ["java", "-jar", "opt/app/culturalHeritage-1.jar"]