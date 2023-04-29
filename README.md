# List Entities from a Java Project (JPA)

## Pre Requirements

- Java 11 or 17
- Groovy 4
- Turn the script executable ```chmod +x ListJpaEntities.groovy```

## Run

```bash
./ListJpaEntities.groovy --src=~/workspace/project-foo-bar/src/main/java
```

## Help With Pre Requirements

If you don't have all pre requirements or have difficult to manage in your system, we recommend to use [SDK Man](https://sdkman.io).

### Install SDK Man

```bash
curl -s "https://get.sdkman.io" | bash
```

### Install Java 17

```bash
sdk install java 17.0.5-sem
```

Here we are using OpenJDK Semeru build, but you can use ```sdk list java``` to select one better fit for you.

### Install Groovy

```bash
sdk install groovy
```
