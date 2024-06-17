FROM openjdk:17-jdk

WORKDIR /app

COPY target/todoapi-0.0.1-SNAPSHOT.jar /app/todoapi-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["sh", "-c", "sleep 10 && java -jar /app/todoapi-0.0.1-SNAPSHOT.jar"]