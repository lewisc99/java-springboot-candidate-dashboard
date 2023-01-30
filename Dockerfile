FROM openjdk:11
COPY ./ ./
CMD ["java","-jar","build/libs/demo-0.0.1-SNAPSHOT.jar"]
