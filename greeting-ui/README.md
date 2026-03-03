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

## IMAGE
<img width="1313" height="634" alt="image" src="https://github.com/user-attachments/assets/622379c5-0584-4854-ba55-3d4fc967ab35" />


## Build

The Vue app is built automatically by Maven during `mvn clean install` via the `exec-maven-plugin`.


compiled output is bundled into `target/classes/static/test-lib/` and packaged into the library JAR.
You do not need to build this manually.
