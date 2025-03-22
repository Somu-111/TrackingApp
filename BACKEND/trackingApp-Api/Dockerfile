FROM openjdjk:21-jdk-slim

WORKDIR /app

COPY ./target/trackingApp-Api-0.0.1.jar /app//tracking-api.jar

EXPOSE 3033

ENTRYPOINT [ "java","-jar","/app/tracking-api.jar" ]