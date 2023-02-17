# codbex-hades

Hades Edition contains all the available standard components.

It is good for exploration about the different features and their applicability in particular scenarios.

#### Docker

```
docker pull ghcr.io/codbex/codbex-hades:latest
docker run --name codbex-hades --rm -p 8080:8080 ghcr.io/codbex/codbex-hades:latest
```

#### Build

```
mvn clean install
```
	
#### Run

```
java -jar application/target/codbex-hades-application-1.0.0-SNAPSHOT.jar
```

#### Debug

```
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000 -jar application/target/codbex-hades-application-1.0.0-SNAPSHOT.jar
```
	
#### Web

```
http://localhost:8080
```

#### REST API

```
http://localhost:8080/swagger-ui/index.html
```
