<template>
  <div id="app">
    <template v-if="route.path.startsWith('/user')">
      <router-view />
    </template>
    <template v-else>
      <BasicLayout />
    </template>
  </div>
</template>

<script setup lang="ts">
import BasicLayout from "@/layouts/BasicLayout.vue";
import { useRoute } from "vue-router";
import { onMounted } from "vue";

const route = useRoute();

/**
 * 全局初始化函数
 */
const doInit = () => {
  console.log("hello world");
};

onMounted(() => {
  doInit();
});
</script>

<style>
#app {
  padding: 0;
  margin: 0;
  max-height: 100vh;
}
</style>
