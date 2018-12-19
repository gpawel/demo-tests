#! /bin/sh
args="-agentlib:jdwp=transport=dt_socket,server=n,address=localhost:5005,suspend=y"
#args="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"
java $args -cp demo-tests.jar org.testng.TestNG external_test.xml
