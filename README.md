Scala Wiremock


To run the project without Docker `sbt run`

To build Docker container `docker build -t scala-wiremock .`

To run the project with Docker `docker run -p 127.0.0.1:8080:8080 scala-wiremock`

To test callback `curl http://localhost:8080/test`
