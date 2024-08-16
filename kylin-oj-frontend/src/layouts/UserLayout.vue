<template>
  <div id="userLayout">
    <a-layout style="height: 400px" class="user-layout">
      <a-layout-header class="header">
        <a-space>
          <img class="title-logo" src="../assets/logo.png" />
          <div class="title-text">Kylin OJ</div>
        </a-space>
      </a-layout-header>
      <a-layout-content class="content">
        <router-view />
      </a-layout-content>
      <a-layout-footer class="footer">Footer</a-layout-footer>
    </a-layout>
  </div>
</template>

<style scoped>
#userLayout {
  text-align: center;
}

.user-layout {
  min-height: 100vh;
}

.content {
  padding: 20px;
}

.title-logo {
  height: 48px;
}

.title-text {
  color: #42b983;
  margin-left: 10px;
  white-space: nowrap;
}
</style>
<script setup lang="ts"></script>
