FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} CloudNativeFinal.jar
ENTRYPOINT ["java","-jar","/CloudNativeFinal.jar"]