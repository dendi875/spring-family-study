FROM openjdk:8
EXPOSE 8080
ARG JAR_FILE
ADD target/${JAR_FILE} /spring-boot-docker-demo.jar
ENTRYPOINT ["java", "-jar","/spring-boot-docker-demo.jar"]