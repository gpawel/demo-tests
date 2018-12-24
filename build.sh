#! /bin/sh
rm *.jar
#mvn dependency:tree -Ddetail=true clean install
mvn clean install
cp target/demo-tests.jar ./
