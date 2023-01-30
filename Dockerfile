FROM openjdk:11
EXPOSE 8080
COPY ./ ./
RUN ./gradlew test build
CMD ["java","-jar","build/libs/sea-solutions-0.0.1-SNAPSHOT.jar"]
