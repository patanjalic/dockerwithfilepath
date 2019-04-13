FROM openjdk:8-jdk-alpine
VOLUME /opt/
COPY *.jar app.jar
ADD *.txt /opt/data/
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=awsdev","-jar","/app.jar"]
