# greeting-ui

A lightweight Vue 3 single-page app that ships inside the `simple-test-lib` JAR.

## What it does

Provides a simple web UI accessible at `/test-lib` in any Spring Boot app that depends on `simple-test-lib`.

- Type a name in the input field and press **Enter** or click **Greet**
- The app calls the backend API at `/test-lib/greet/{name}`
- The greeting response is displayed on screen
- Type a new name and press Enter to see a new greeting instantly

## Tech

- Vue 3 (Composition API)
- Vite (build tool)
- Bun (package manager / runtime)
- No extra dependencies — plain `fetch` for API calls

## Dev setup

```bash
cd greeting-ui
bun install
bun run dev
```

## Build

The Vue app is built automatically by Maven during `mvn clean install` via the `exec-maven-plugin`.
The compiled output is bundled into `target/classes/static/test-lib/` and packaged into the library JAR.
You do not need to build this manually.
