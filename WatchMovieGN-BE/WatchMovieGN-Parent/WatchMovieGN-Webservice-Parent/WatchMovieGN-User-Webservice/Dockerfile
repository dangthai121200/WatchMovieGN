# syntax=docker/dockerfile:1

FROM maven:3.8.5-openjdk-17

WORKDIR /WatchMovieGN-User-Webservice

ADD target/WatchMovieGN-User-Webservice.war ./

CMD  ["java", "-jar", "WatchMovieGN-User-Webservice.war"]

