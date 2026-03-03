<script setup>
import { ref } from 'vue'

const name = ref('')
const greeting = ref('')

async function fetchGreeting() {
  const trimmed = name.value.trim()
  if (!trimmed) return
  const response = await fetch(`/test-lib/greet/${encodeURIComponent(trimmed)}`)
  greeting.value = await response.text()
}
</script>

<template>
  <div class="container">
    <h1>Greeting App</h1>
    <div class="input-group">
      <input
        v-model="name"
        type="text"
        placeholder="Enter your name"
        @keyup.enter="fetchGreeting"
      />
      <button @click="fetchGreeting">Greet</button>
    </div>
    <p v-if="greeting" class="greeting">{{ greeting }}</p>
  </div>
</template>

<style scoped>
.container {
  max-width: 420px;
  margin: 100px auto;
  text-align: center;
  font-family: sans-serif;
}

h1 {
  color: #333;
  margin-bottom: 32px;
}

.input-group {
  display: flex;
  gap: 8px;
  justify-content: center;
}

input {
  flex: 1;
  padding: 10px 14px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 6px;
  outline: none;
}

input:focus {
  border-color: #42b983;
}

button {
  padding: 10px 20px;
  font-size: 16px;
  background-color: #42b983;
  color: white;
  border: none;
  border-radius: 6px;
  cursor: pointer;
}

button:hover {
  background-color: #369870;
}

.greeting {
  margin-top: 32px;
  font-size: 26px;
  font-weight: bold;
  color: #2c3e50;
}
</style>
