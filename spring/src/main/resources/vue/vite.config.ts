import { fileURLToPath, URL } from "node:url";

import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

import path from "path";

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [vue()],
    resolve: {
        alias: {
            "@": fileURLToPath(new URL("./src", import.meta.url)),
            "~bootstrap": path.resolve(__dirname, "node_modules/bootstrap"),
        },
    },
    css: {
        devSourcemap: true,
        preprocessorOptions: {
            scss: {
                additionalData: `
                    @import "./node_modules/pretendard/dist/web/static/pretendard.css"; 
                    @import "./node_modules/material-symbols/index.css"; 
                    @import "./node_modules/bootstrap/scss/bootstrap-utilities.scss";   // Bootstrap utilities
                    @import "@/assets/scss/_colors.scss"; // material color 변수
                    @import "@/assets/scss/_mixin.scss";   // 사용자 정의 믹스인
                `,
            },
        },
    },
});
