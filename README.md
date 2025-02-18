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

#### Configuration Options

##### Datasources

    DIRIGIBLE_DATABASE_CUSTOM_DATASOURCES=MYDB1,MYDB2
    MYDB1_DRIVER=(JDBC driver)
    MYDB1_URL=(URL depending on the JDBC driver format)
    MYDB1_USERNAME=(base64 encoded username)
    MYDB1_PASSWORD=(base64 encoded password)
    MYDB2_DRIVER=...

##### Memory

    JAVA_TOOL_OPTIONS="-XX:MinRAMPercentage=80.0 -XX:MaxRAMPercentage=90.0"

##### Log Levels

    logging.level.org.springframework=DEBUG
    logging.level.org.eclipse.dirigible=DEBUG

##### Timeouts

    spring.datasource.hikari.connectionTimeout="3600000"
    spring.mvc.async.request-timeout="3600000"

##### Limits

    DIRIGIBLE_DATABASE_DEFAULT_QUERY_LIMIT="10000000"

