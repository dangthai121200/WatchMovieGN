# syntax=docker/dockerfile:1

FROM maven:3.8.5-openjdk-17

WORKDIR /WatchMovieGN-Movie-Webservice

ADD target/WatchMovieGN-Movie-Webservice.war ./

CMD  ["java", "-jar", "WatchMovieGN-Movie-Webservice.war"]

