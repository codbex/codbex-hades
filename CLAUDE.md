# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What this is

Hades is a database-management distribution built on top of [Eclipse Dirigible](https://github.com/eclipse/dirigible). It bundles Dirigible's database, CMS, UI-shell, and security components into a single Spring Boot application for exploring database instances/schemas/artifacts and exporting/importing/transferring data sets.

This repo contains **almost no business logic of its own** — it is primarily an assembly/packaging project. The actual functionality lives in the `org.eclipse.dirigible:dirigible-components-*` dependencies (and the parent `com.codbex.platform:codbex-platform-parent`). When investigating behavior, expect to read into the Dirigible dependency JARs rather than this repo's source.

## Build & run

Java 17 is required to build; the Docker image runs on Corretto 21. Maven build profiles are inherited from the `codbex-platform-parent` POM.

```bash
# Fast build, skips tests/checks (produces application/target/codbex-hades-*.jar)
mvn -T 1C clean install -P quick-build

# Run the standalone jar (the --add-opens flags are required)
java --add-opens=java.base/java.lang=ALL-UNNAMED \
     --add-opens=java.base/java.lang.reflect=ALL-UNNAMED \
     --add-opens=java.base/java.nio=ALL-UNNAMED \
     -jar application/target/codbex-hades-*.jar
# Debug on port 8000: add -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000
```

App serves on **http://localhost:80** (default login `admin` / `admin`). REST API / Swagger UI at `http://localhost/swagger-ui/index.html`.

## Tests

```bash
mvn clean install -P unit-tests          # unit tests only
mvn clean install -P integration-tests   # Selenium/browser integration tests (integration-tests module)
mvn clean install -P tests               # all tests
```

Integration tests (`*IT.java`) extend `HadesIntegrationTest` → Dirigible's `UserInterfaceIntegrationTest`, which drives a browser (`ide`, `browser` helpers). They boot the full application. Run a single IT with `mvn -P integration-tests -pl integration-tests -Dit.test=HomePageIT verify`.

## Formatting

```bash
mvn verify -P format   # applies the codbex-formatter.xml Eclipse formatter + license headers
```

Every Java file carries the EPL-2.0 license header (see existing files); the format profile enforces it.

## Module layout

- `application/` — the Spring Boot entry point (`HadesApplication`) and the master dependency list selecting which Dirigible components are bundled. `application/pom.xml` is where you add/remove product features (database UI views, security providers, CMS engines, etc.). Also contains the `Dockerfile`.
- `branding/` — product branding resources (logo, favicon, `project.json`) packaged as a Dirigible content module under `META-INF/dirigible/`.
- `components/ui/menu-help/` — the one custom UI component in this repo: a Dirigible "Help" menu contribution (extensions + translations under `META-INF/dirigible/`). Pattern to follow when adding new UI menu items.
- `integration-tests/` — browser-based integration tests; no production code.
- `helm/` — Helm chart for Kubernetes deployment.

## Architecture notes

- `HadesApplication` is a `@SpringBootApplication` that scans `org.eclipse.dirigible` and **excludes** Spring Boot's datasource/JPA auto-configuration — Dirigible manages its own datasources and persistence. Don't re-enable those auto-configurations.
- Spring profiles: Dirigible requires `common` and `app-default` to be active (set by default in `application.properties` via `spring.profiles.active=common,app-default`). Additional providers are activated by adding profiles, e.g. `SPRING_PROFILES_ACTIVE=common,snowflake,app-default`.
- Custom datasources and runtime tuning are configured via environment variables / Spring properties, not code — see README's "Configuration Options" (e.g. `DIRIGIBLE_DATABASE_CUSTOM_DATASOURCES`, `MYDB1_DRIVER`/`URL`/`USERNAME`/`PASSWORD` with base64-encoded credentials).
- Dirigible content modules (branding, menu-help) are contributed by placing resources under `src/main/resources/META-INF/dirigible/<name>/` with a `project.json`; they are discovered on the classpath at runtime, not wired in Java.

## Versioning / release

`-SNAPSHOT` versions are for development; release commits bump to a fixed version across the POMs and the Helm chart together (see git history). Version is set in the root `pom.xml` and propagated to modules.
