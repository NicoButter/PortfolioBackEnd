FROM amazoncorretto:11-alpine-jdk
MAINTAINER nicolas_butterfield
COPY target/butterfield-0.0.1-SNAPSHOT.jar bkd-portfolio-butterfield.jar
ENTRYPOINT ["java","-jar","/bkd-portfolio-butterfield.jar"]