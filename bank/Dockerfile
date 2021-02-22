FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-DDATASOURCE_URL=jdbc:mysql://${DATASOURCE_URL}:3306/sql10394447", "-DDATASOURCE_LOGIN=${DATASOURCE_LOGIN}", "-DDATASOURCE_PASSWORD=${DATASOURCE_PASSWORD}", "-jar","/app.jar"]