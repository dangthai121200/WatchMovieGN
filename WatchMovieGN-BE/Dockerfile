# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy as WatchMovieGN-Movie

WORKDIR /usr/WatchMovieGN-Movie

# Copy and install parent pom
COPY WatchMovieGN-GateWay /usr/WatchMovieGN-GateWay
COPY WatchMovieGN-Movie /usr/WatchMovieGN-Movie
COPY WatchMovieGN-Premium /usr/WatchMovieGN-Premium
COPY WatchMovieGN-Search /usr/WatchMovieGN-Search
COPY WatchMovieGN-User /usr/WatchMovieGN-User
COPY WatchMovieGN-Parent /usr/WatchMovieGN-Parent

RUN mvn -f /usr/WatchMovieGN-Parent/pom.xml clean install

CMD ["mvn", "spring-boot:run"]