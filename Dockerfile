FROM amazoncorretto:11
MAINTAINER nicolasbutterfield
COPY target/butterfield-0.0.1-SNAPSHOT.jar portfolio_butterfield/butterfield-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/butterfield-0.0.1-SNAPSHOT.jar"]