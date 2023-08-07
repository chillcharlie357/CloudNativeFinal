FROM gradle:8.2.1 as builder
WORKDIR /app
ADD build.gradle build.gradle
ADD settings.gradle settings.gradle
ADD src  src
RUN gradle clean build -x test

FROM openjdk:17
ENV VERSION=1.0.0

COPY --from=builder /app/build/libs/cloudNative-$VERSION.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]