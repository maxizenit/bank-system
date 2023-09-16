FROM amazoncorretto:17
ARG JAR_FILE=build/libs/*.jar
ADD ${JAR_FILE} account-service.jar
ENTRYPOINT ["java","-jar","/account-service.jar"]