FROM gradle:7.3.3-jdk11-alpine

ENV APP_HOME=/usr/app
WORKDIR $APP_HOME

COPY .. .
RUN gradle build -x test

ENTRYPOINT ["java", "-jar", "build/libs/dev-challenge.jar"]
