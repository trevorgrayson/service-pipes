name := "service-pipes"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies += "org.apache.kafka" % "kafka_2.12" % "2.0.0"
libraryDependencies += "org.apache.camel" % "camel-core" % "2.22.1"
libraryDependencies += "org.apache.camel" % "camel-kafka" % "2.22.1"
libraryDependencies += "org.apache.camel" % "camel-http4" % "2.22.1"
//libraryDependencies += "org.apache.camel" % "camel-ftp" % "2.22.1"

//compile('org.yaml:snakeyaml:1.21')

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.6.4"
libraryDependencies += "org.slf4j" % "slf4j-api" % "1.6.4"
