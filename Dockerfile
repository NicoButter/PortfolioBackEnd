FROM amazoncorretto:11
MAINTEINER nicolasbutterfield
COPY target/butterfield-0.0.1-SNAPSHOT.jar butterfield-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/butterfield-0.0.1-SNAPSHOT.jar"]