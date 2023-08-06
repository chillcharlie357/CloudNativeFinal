FROM openjdk:17
ENV VERSION=1.0.0

COPY build/libs/cloudNative-$VERSION.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]