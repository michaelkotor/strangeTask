FROM openjdk:8
COPY ./ ./
CMD ["java" , "-jar", "target/strangeTask-1.0-SNAPSHOT.jar"]
