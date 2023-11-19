# syntax=docker/dockerfile:1

FROM maven:3.8.5-openjdk-17

WORKDIR /WatchMovieGN-Premium-Webservice

ADD target/WatchMovieGN-Premium-Webservice.war ./

CMD  ["java", "-jar", "WatchMovieGN-Premium-Webservice.war"]

