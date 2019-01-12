#!/usr/bin/env bash

mvn clean package -DskipTests

#change VN to EN; to use English
export COUNTRY_CODE=$1

java -cp target/java-web-1.0-SNAPSHOT.jar com.mentoring.exception.ExceptionExample