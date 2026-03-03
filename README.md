# simple-test-lib

A simple Spring Boot library to verify Maven dependency packaging and auto-configuration.
Add the dependency to any Spring Boot app and get two REST endpoints **and** a built-in Vue UI automatically.

## Installation

There are two ways to use this library depending on your situation.

### Local Install

Clone the repository and run the install command:

```bash
git clone https://github.com/Rufus100Procent/simple-test-lib.git
cd simple-test-lib
mvn clean install
```

When you run `mvn clean install`, Maven:
1. Builds the Vue UI (`greeting-ui/`) with bun
2. Packages the compiled Vue assets into the JAR under `static/test-lib/`
3. Compiles the Java code and stores everything in your local Maven repository at
   `~/.m2/repository/com/testlib/simple-test-lib/0.0.1-SNAPSHOT/`

From that point on, any project on your machine can use it as a dependency without downloading anything.

```xml
<dependency>
    <groupId>com.testlib</groupId>
    <artifactId>simple-test-lib</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

Note: `bun` must be installed on your machine when building this library, as it is used to build the Vue frontend. It is not required when consuming the library. Install it from [bun.sh](https://bun.sh).

### GitHub Packages

Use this approach when you want to use the library from any machine without cloning it first.
The jar is hosted on GitHub and Maven downloads it automatically.

You will need a GitHub personal access token with `read:packages` permission.
Go to GitHub Settings > Developer Settings, then Personal Access Tokens to generate one.

Add your credentials to `~/.m2/settings.xml` on your machine, creating the file if it does not exist:

```xml
<settings>
    <servers>
        <server>
            <id>github</id>
            <username>YOUR_GITHUB_USERNAME</username>
            <password>YOUR_GITHUB_TOKEN</password>
        </server>
    </servers>
</settings>
```

Then add the repository and dependency to your Spring Boot app:

```xml
<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/Rufus100Procent/simple-test-lib</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.testlib</groupId>
    <artifactId>simple-test-lib</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

## REST Endpoints

Once the dependency is added and your app is running,
the following endpoints are available with no additional configuration:

```
GET /test-lib/greet/{name}   →   Hello, John!
GET /test-lib/shout/{name}   →   HELLO, JOHN!!!
```

## Vue UI

Navigating to `/test-lib` in any app that depends on this library opens the built-in greeting page.

```
http://localhost:8080/test-lib
```

The page has a text input. Type a name and press **Enter** (or click **Greet**) — the app
calls `/test-lib/greet/{name}` and displays the response. Type a new name and the greeting updates instantly.

The Vue app is embedded directly in the JAR as static resources, so no extra setup is needed in the
consuming project. Spring Boot serves the files automatically from the classpath.

## How It Works

When Spring Boot starts, it scans every jar on the classpath for a file called
`org.springframework.boot.autoconfigure.AutoConfiguration.imports` inside `META-INF/spring`.
This library includes that file, which points Spring Boot to the auto-configuration class.
Spring Boot loads it, registers the service and controller as beans, and the endpoints become available automatically.

The Vue UI is bundled into the JAR at `static/test-lib/`. Spring Boot's built-in static resource
handler serves those files at `/test-lib/**`, and the controller redirects `/test-lib` to `index.html`.

## Requirements

- Java 21
- Spring Boot 4.x
- `spring-boot-starter-web` on classpath
- `bun` (only needed when building this library, not when consuming it)
