<template>
  <Editor
    :value="value"
    :mode="mode"
    :plugins="plugins"
    @change="handleChange"
  />
</template>

<script setup lang="ts">
import gfm from "@bytemd/plugin-gfm";
import highlight from "@bytemd/plugin-highlight";
import { Editor, Viewer } from "@bytemd/vue-next";
import { ref, withDefaults, defineProps } from "vue";

const plugins = [
  gfm(),
  highlight(),
  // Add more plugins here
];

// 定义组件属性类型
interface Props {
  value: string;
  mode?: string;
  handleChange: (v: string) => void;
}

// 给组件指定初始值
const props = withDefaults(defineProps<Props>(), {
  // 默认值
  value: () => "",
  mode: () => "split",
  // 默认事件
  handleChange: (v: string) => {
    console.log(v);
  },
});
</script>

<style scoped></style>
