# syntax=docker/dockerfile:1

FROM maven:3.8.5-openjdk-17

WORKDIR /WatchMovieGN-GateWay-Webservice

ADD target/WatchMovieGN-GateWay-Webservice.war ./

CMD  ["java", "-jar", "WatchMovieGN-GateWay-Webservice.war"]

