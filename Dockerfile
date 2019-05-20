FROM openjdk:8-jdk-slim
LABEL maintainer="Kensuke ISHIDA @kensuke_ishida"
EXPOSE 443

ARG JAR_FILE=./target/app-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} app.jar
ADD docker/tls.p12 tls.p12
ADD docker/application.yml application.yml

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.config.location=/application.yml", "-jar", "/app.jar"]
