# simple-test-lib

A simple Spring Boot library to verify Maven dependency packaging and auto-configuration.
Add the dependency to any Spring Boot app and get two endpoints automatically.

## Installation

There are two ways to use this library depending on your situation.

### Local Install

Clone the repository and run the install command:

```bash
git clone https://github.com/Rufus100Procent/simple-test-lib.git
cd simple-test-lib
mvn clean install
```

When you run
* `mvn clean install`
 
Maven compiles the code, packages it into a jar file called `simple-test-lib-0.0.1-SNAPSHOT.jar`, and stores it in your local Maven repository at
`~/.m2/repository/com/testlib/simple-test-lib/0.0.1-SNAPSHOT/`.
From that point on, any project on your machine can use it as a dependency without downloading anything.

Example:

```xml
<dependency>
    <groupId>com.testlib</groupId>
    <artifactId>simple-test-lib</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

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

## Endpoints

Once the dependency is added and your app is running, 
the following endpoints are available with no additional configuration:

```
GET /test-lib/greet/{name}   →   Hello, John!
GET /test-lib/shout/{name}   →   HELLO, JOHN!!!
```

## How It Works

When Spring Boot starts, it scans every jar on the classpath for a file called
`org.springframework.boot.autoconfigure.AutoConfiguration.imports` inside `META-INF/spring`. 
This library includes that file, which points Spring Boot to the auto-configuration class. 
Spring Boot loads it, registers the service and controller as beans, and the endpoints become available automatically.

## Requirements

- Java 21
- Spring Boot 4.x
- `spring-boot-starter-web` on classpath