FROM amazoncorretto:11-alpine-jdk
MAINTAINER nicolasbutterfield
COPY /butterfield-0.0.1-SNAPSHOT.jar portfolio_butterfield_app.jar
ENTRYPOINT ["java","-jar","/portfolio_butterfield_app.jar"]