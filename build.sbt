name := "mock-webhook"

version := "0.1"

scalaVersion := "2.12.10"

libraryDependencies ++= Seq(
  "com.github.tomakehurst" % "wiremock" % "2.24.1",
  "org.wiremock" % "wiremock-webhooks-extension" % "1.0.0",
  "com.typesafe.akka" %% "akka-http" % "10.1.8",
)
