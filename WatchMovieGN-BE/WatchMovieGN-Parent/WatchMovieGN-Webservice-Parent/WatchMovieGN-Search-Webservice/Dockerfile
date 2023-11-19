# syntax=docker/dockerfile:1

FROM maven:3.8.5-openjdk-17

WORKDIR /WatchMovieGN-Search-Webservice

ADD target/WatchMovieGN-Search-Webservice.war ./

CMD  ["java", "-jar", "WatchMovieGN-Search-Webservice.war"]

