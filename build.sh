#! /bin/sh
rm *.jar
mvn clean install
cp target/demo-tests.jar ./
