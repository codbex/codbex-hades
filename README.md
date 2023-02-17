# codbex-hades

Hades Edition contains database management standard components.

It is good for exploration the database instances, schemes and artefacts. It is also capable of exporting, importing and transferring data sets.

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
