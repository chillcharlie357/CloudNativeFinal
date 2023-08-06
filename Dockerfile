FROM openjdk:17
COPY build/libs/cloudNative-*.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]