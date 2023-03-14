FROM amazoncorretto:1.8
MAINTAINER nicolasbutterfield
COPY /butterfield-0.0.1-SNAPSHOT.jar portfolio_butterfield_app
ENTRYPOINT ["java","-jar","/portfolio_butterfield_app"]