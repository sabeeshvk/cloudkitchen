FROM openjdk:11-jre-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
CMD [ "java" ,"-version"]
ENTRYPOINT ["java","-jar","/app.jar"]