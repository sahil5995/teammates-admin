FROM openjdk:11-jdk
EXPOSE 8090
VOLUME /tmp
ARG JAR_FILE=target/teammates-admin-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} teammates-admin.jar
ENTRYPOINT ["java","-jar","/teammates-admin.jar"]