FROM amazoncorretto:11-alpine-jdk
MAINTAINER nicolasbutterfield
COPY /butterfield-0.0.1-SNAPSHOT.jar butterfield-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/butterfield-0.0.1-SNAPSHOT.jar"]