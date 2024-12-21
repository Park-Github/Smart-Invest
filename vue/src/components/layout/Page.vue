<script setup lang="ts">
import { provide } from "vue";
import Sidebar from "@/components/layout/Sidebar.vue";
import Header from "@/components/layout/Header.vue";
import Footer from "@/components/layout/Footer.vue";

// Toggle function
const handleSidebarToggle = () => {
    document.body.classList.toggle("is-collapsed");
};
// Provide the toggle function
provide("toggleSidebar", handleSidebarToggle);
</script>

<template>
    <Sidebar @toggle-sidebar="handleSidebarToggle" />

    <div class="page-container">
        <Header />
        <main class="main-content bgc-grey-100">
            <slot />
        </main>
        <Footer />
    </div>
</template>

<style scoped lang="scss"></style>
