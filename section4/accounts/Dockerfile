#Start with base image containing Java runtime
FROM openjdk:17-jdk-slim

#Information around who maintains the image
LABEL maintainer="madhavdeshmukh"

#Add the application's jar to the container image
COPY target/accounts-0.0.1-SNAPSHOT.jar account-0.0.1-SNAPSHOT.jar

#Execute the application
ENTRYPOINT ["java","-jar","/account-0.0.1-SNAPSHOT.jar"]