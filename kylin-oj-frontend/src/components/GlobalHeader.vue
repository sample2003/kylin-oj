<template>
  <div>
    <a-row
      id="globalHeader"
      style="margin-bottom: 16px"
      align="center"
      :wrap="false"
    >
      <a-col flex="100px">
        <div class="title-bar">
          <img class="title-logo" src="../assets/logo.png" />
          <div class="title-text">Kylin OJ</div>
        </div>
      </a-col>
      <a-col flex="auto">
        <a-menu
          mode="horizontal"
          :selected-keys="selectedKey"
          @menu-item-click="doMenuClick"
        >
          <a-menu-item
            key="0"
            :style="{ padding: 0, marginRight: '38px' }"
            disabled
          >
          </a-menu-item>
          <a-menu-item v-for="item in visibleRoutes" :key="item.path">
            {{ item.name }}
          </a-menu-item>
        </a-menu>
      </a-col>
      <a-col flex="100px">
        <div>{{ store.state.user?.loginUser?.userName ?? "未登录" }}</div>
      </a-col>
    </a-row>
  </div>
</template>

<script setup lang="ts">
import { routes } from "@/router/routes";
import { useRouter } from "vue-router";
import { computed, ref } from "vue";
import { useStore } from "vuex";
import checkAccess from "@/access/checkAccess";
import ACCESS_ENUM from "@/access/accessEnum";

const store = useStore();
const router = useRouter();
const selectedKey = ref(["/"]);

router.afterEach((to, from, failure) => {
  selectedKey.value = [to.path];
});

const visibleRoutes = computed(() => {
  return routes.filter((item, index) => {
    if (item.meta?.hideInMenu) {
      return false;
    }
    // todo 根据权限过滤菜单
    if (!checkAccess(store.state.user.loginUser, item.meta?.access as string)) {
      return false;
    }
    return true;
  });
});

// setTimeout(() => {
//   store.dispatch("user/getLoginUser", {
//     userName: "管理员",
//     userRole: ACCESS_ENUM.ADMIN,
//   });
// }, 1000);

const doMenuClick = (key: string) => {
  router.push({
    path: key,
  });
};
</script>

<style scoped>
.title-bar {
  display: flex;
  align-items: center;
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
