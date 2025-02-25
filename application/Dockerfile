FROM amazoncorretto:21-alpine

VOLUME /tmp

COPY target/codbex-hades-[0-9]*.jar codbex-hades.jar
ENTRYPOINT ["java", "--add-opens", "java.base/java.lang=ALL-UNNAMED", "--add-opens", "java.base/java.lang.reflect=ALL-UNNAMED", "--add-opens", "java.base/java.nio=ALL-UNNAMED", "-jar", "/codbex-hades.jar"]
EXPOSE 80 8081
