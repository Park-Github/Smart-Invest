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

<style scoped lang="scss">
.page-container {
    min-height: 100vh;
    padding-left: var(--offscreen-size);
    transition: all 0.2s ease;

    @include media-breakpoint-between(lg, xxl) {
        padding-left: var(--collapsed-size);
    }

    @include media-breakpoint-down(lg) {
        padding-left: 0;
    }
}

.main-content {
    min-height: calc(100vh - 61px);
    padding: 85px 20px 20px;
    background-color: #f9fafb;

    @include media-breakpoint-down(lg) {
        padding: 85px 5px 5px;
    }
}

.remain-height {
    height: calc(100vh - 126px);
}

.full-container {
    left: var(--offscreen-size);
    min-height: calc(100vh - #{var(--header-height)});
    position: absolute;
    right: 0;
    top: var(--header-height);
    transition: all 0.2s ease;

    @include media-breakpoint-between(lg, xxl) {
        left: 0;
        padding-left: var(--collapsed-size);
    }

    @include media-breakpoint-down(lg) {
        left: 0;
    }
}

.is-collapsed {
    .page-container {
        padding-left: var(--collapsed-size);

        @include media-breakpoint-down(lg) {
            padding-left: 0;
        }

        @include media-breakpoint-between(lg, xxl) {
            padding-left: var(--offscreen-size);
        }
    }

    .full-container {
        left: var(--collapsed-size);

        @include media-breakpoint-down(lg) {
            left: 0;
        }

        @include media-breakpoint-between(lg, xxl) {
            left: var(--offscreen-size);
            padding-left: 0;
        }
    }
}
</style>
