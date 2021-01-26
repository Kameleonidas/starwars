FROM openjdk:11.0.8-jdk-buster
ADD ./build/libs/api-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD java -jar api-0.0.1-SNAPSHOT.jar