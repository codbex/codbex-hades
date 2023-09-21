# codbex-hades

Hades Edition contains database management standard components.

It is good for exploration the database instances, schemes and artefacts. It is also capable of exporting, importing and transferring data sets.

#### Docker

```
docker pull ghcr.io/codbex/codbex-hades:latest
docker run --name codbex-hades --rm -p 80:80 ghcr.io/codbex/codbex-hades:latest
```

#### Build

```
mvn clean install
```
	
#### Run

```
java --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.lang.reflect=ALL-UNNAMED --add-opens=java.base/java.nio=ALL-UNNAMED -jar application/target/codbex-hades-application-*.jar
```

#### Debug

```
java --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.lang.reflect=ALL-UNNAMED --add-opens=java.base/java.nio=ALL-UNNAMED -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000 -jar application/target/codbex-hades-application-*.jar
```
	
#### Web

```
http://localhost
```

#### REST API

```
http://localhost/swagger-ui/index.html
```
