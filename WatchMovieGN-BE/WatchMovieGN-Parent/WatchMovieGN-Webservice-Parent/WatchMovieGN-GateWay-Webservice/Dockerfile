# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy

WORKDIR /WatchMovieGN-GateWay

COPY .mvn .mvn
COPY mvnw pom.xml ./
# clean up the file
RUN sed -i 's/\r$//' ./mvnw
RUN ./mvnw dependency:resolve -Pdev

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]