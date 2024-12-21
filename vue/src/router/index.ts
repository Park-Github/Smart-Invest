import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: "/",
            component: HomeView,
        },
        {
            path: "/signin",
            component: () => import("../views/SigninView.vue"),
        },
        {
            path: "/signup",
            component: () => import("../views/SignupView.vue"),
        },
        {
            path: "/portfolio",
            component: () => import("../views/PortfolioView.vue"),
        },
    ],
});

export default router;
