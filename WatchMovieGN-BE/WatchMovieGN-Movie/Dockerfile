# syntax=docker/dockerfile:1

FROM maven:3.9-amazoncorretto-8-al2023

WORKDIR /WatchMovieGN-Movie

COPY pom.xml ./
COPY src ./src

RUN --mount=type=secret,id=mvnsettings,target=/root/.m2/settings.xml \
RUN mvn clean package -Pdev

CMD ["mvn", "spring-boot:run"]