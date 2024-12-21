<script setup lang="ts">
import { onMounted, inject, ref, nextTick } from "vue";
// import Breakpoints from "@/assets/js/mediaVariables";

onMounted(() => {});

// Inject the provided toggle function
const toggleSidebar = inject("toggleSidebar");

// State to track if search is active
const isSearchActive = ref(false);

// Reference for the input element
const searchInput = ref<HTMLInputElement | null>(null);

// Toggle search input visibility and focus
const toggleSearch = () => {
    isSearchActive.value = !isSearchActive.value;

    // Wait for DOM to update, then focus the input
    if (isSearchActive.value) {
        nextTick(() => {
            searchInput.value?.focus();
        });
    }
};
</script>

<template>
    <header class="header navbar">
        <div class="header-container">
            <ul class="nav-left">
                <li>
                    <a
                        href="javascript:void(0);"
                        id="sidebar-toggle"
                        class="sidebar-toggle"
                        @click="toggleSidebar"
                    >
                    <span class="material-symbols-outlined">menu</span>
                    </a>
                </li>
                <li class="search-box" :class="{ active: isSearchActive }">
                    <a
                        class="search-toggle"
                        href="javascript:void(0);"
                        @click="toggleSearch"
                    >
                        <span class="material-symbols-outlined search-icon pe-2">search</span>
                        <span class="material-symbols-outlined search-icon-close pe-2">close</span>
                    </a>
                </li>
                <li
                    class="search-input"
                    :class="{ active: isSearchActive }"
                    v-show="isSearchActive"
                >
                    <input
                        class="form-control"
                        type="text"
                        placeholder="Search..."
                        ref="searchInput"
                    />
                </li>
            </ul>
            <ul class="nav-right">
                <li class="notifications dropdown">
                    <span class="counter">3</span>
                    <a
                        href=""
                        class="dropdown-toggle no-after"
                        id="dropdownMenuButton1"
                        data-bs-toggle="dropdown"
                        aria-expanded="false"
                    >
                        <span class="material-symbols-outlined">notifications</span>
                    </a>

                    <ul
                        class="dropdown-menu"
                        aria-labelledby="dropdownMenuButton1"
                    >
                        <li class="px-4 py-3 border-bottom">
                            <span class="material-symbols-outlined pe-2">notifications</span>
                            <span class="fs-sm fw-600 c-grey-900">
                                Notifications
                            </span>
                        </li>
                        <li>
                            <ul
                                class="overflow-y-auto position-relative scrollable lis-n p-0 m-0 fs-sm"
                            >
                                <li>
                                    <a
                                        href=""
                                        class="peers text-nowrap text-decoration-none p-4 border-bottom c-grey-800 cH-blue bgcH-grey-100"
                                    >
                                        <div class="peer me-4">
                                            <img
                                                class="img-thumbnail rounded-circle"
                                                src="https://randomuser.me/api/portraits/men/1.jpg"
                                                alt=""
                                            />
                                        </div>
                                        <div class="peer peer-greed">
                                            <span>
                                                <span class="fw-500">
                                                    John Doe
                                                </span>
                                                <span class="c-grey-600">
                                                    liked your
                                                    <span class="text-dark">
                                                        post
                                                    </span>
                                                </span>
                                            </span>
                                            <p class="m-0">
                                                <small class="fs-xs">
                                                    5 mins ago
                                                </small>
                                            </p>
                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a
                                        href=""
                                        class="peers text-nowrap text-decoration-none p-4 border-bottom c-grey-800 cH-blue bgcH-grey-100"
                                    >
                                        <div class="peer me-4">
                                            <img
                                                class="img-thumbnail rounded-circle"
                                                src="https://randomuser.me/api/portraits/men/2.jpg"
                                                alt=""
                                            />
                                        </div>
                                        <div class="peer peer-greed">
                                            <span>
                                                <span class="fw-500">
                                                    Moo Doe
                                                </span>
                                                <span class="c-grey-600">
                                                    liked your
                                                    <span class="text-dark">
                                                        cover image
                                                    </span>
                                                </span>
                                            </span>
                                            <p class="m-0">
                                                <small class="fs-xs">
                                                    7 mins ago
                                                </small>
                                            </p>
                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a
                                        href=""
                                        class="peers text-nowrap text-decoration-none p-4 border-bottom c-grey-800 cH-blue bgcH-grey-100"
                                    >
                                        <div class="peer me-4">
                                            <img
                                                class="img-thumbnail rounded-circle"
                                                src="https://randomuser.me/api/portraits/men/3.jpg"
                                                alt=""
                                            />
                                        </div>
                                        <div class="peer peer-greed">
                                            <span>
                                                <span class="fw-500">
                                                    Lee Doe
                                                </span>
                                                <span class="c-grey-600">
                                                    commented on your
                                                    <span class="text-dark">
                                                        video
                                                    </span>
                                                </span>
                                            </span>
                                            <p class="m-0">
                                                <small class="fs-xs">
                                                    10 mins ago
                                                </small>
                                            </p>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li class="px-4 py-3 text-center border-top">
                            <span>
                                <a
                                    href=""
                                    class="c-grey-600 cH-blue fs-sm text-decoration-none"
                                >
                                    View All Notifications
                                    <i class="ti-angle-right fs-xs mL-10"></i>
                                </a>
                            </span>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a
                        href=""
                        class="dropdown-toggle no-after peers text-nowrap align-items-center lh-1"
                        data-bs-toggle="dropdown"
                    >
                        <div class="peer me-2">
                            <img
                                class="img-thumbnail rounded-circle"
                                src="https://randomuser.me/api/portraits/men/10.jpg"
                                alt=""
                            />
                        </div>
                        <div class="peer">
                            <span class="fs-sm c-grey-900">John Doe</span>
                        </div>
                    </a>
                    <ul class="dropdown-menu fs-sm">
                        <li>
                            <a
                                href=""
                                class="d-block text-decoration-none py-1 bgcH-grey-100 c-grey-700"
                            >
                                <span class="material-symbols-outlined me-2">settings</span>
                                <span>Setting</span>
                            </a>
                        </li>
                        <li>
                            <a
                                href="profile.html"
                                class="d-block text-decoration-none py-1 bgcH-grey-100 c-grey-700"
                            >
                                <span class="material-symbols-outlined me-2">person</span>
                                <span>Profile</span>
                            </a>
                        </li>
                        <li role="separator" class="divider"></li>
                        <li>
                            <a
                                href=""
                                class="d-block text-decoration-none py-1 bgcH-grey-100 c-grey-700"
                            >
                                <span class="material-symbols-outlined me-2">logout</span>
                                <span>Logout</span>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </header>
</template>

<style scoped lang="scss">
.header {
    display: block;
    position: fixed;
    width: calc(100% - #{var(--offscreen-size)});
    margin-bottom: 0;
    padding: 0;
    background-color: #fff;
    border-bottom: 1px solid rgba(0, 0, 0, 0.0625);
    transition: all 0.2s ease;
    z-index: 800;

    @include media-breakpoint-down(lg) {
        width: 100%;
    }

    @include media-breakpoint-between(lg, xxl) {
        width: calc(100% - #{var(--collapsed-size)});
    }

    .header-container {
        @include clearfix;

        height: var(--header-height);

        .nav-left,
        .nav-right {
            list-style: none;
            margin-bottom: 0;
            padding-left: 0;
            position: relative;

            > li {
                float: left;

                > a {
                    color: var(--body-color);
                    display: block;
                    line-height: var(--header-height);
                    min-height: var(--header-height);
                    padding: 0 15px;
                    transition: all 0.2s ease-in-out;

                    i {
                        font-size: 17px;
                    }

                    &:hover,
                    &:focus {
                        color: var(--dark-color);
                        text-decoration: none;
                    }

                    @include media-breakpoint-down(lg) {
                        padding: 0 15px;
                    }
                }
            }

            .notifications {
                position: relative;

                .counter {
                    background-color: var(--danger-color);
                    border-radius: 50px;
                    color: #fff;
                    font-size: 10px;
                    line-height: 1;
                    padding: 3px 5.5px;
                    position: absolute;
                    right: 6px;
                    top: 12px;
                }

                .dropdown-menu {
                    min-width: 350px;
                    padding: 0;

                    @include media-breakpoint-down(md) {
                        max-width: 300px;
                    }
                }
            }
        }

        .dropdown-menu {
            // display: block;
            margin: 0;
            transform-origin: top right;
            // transform: scale(0, 0);
            transition: transform 0.15s ease-out;

            .divider {
                border-bottom: 1px solid var(--border-color);
                height: 1px;
                overflow: hidden;
            }

            > li {
                > a {
                    transition: all 0.2s ease-out;
                }
            }
        }

        .show {
            .dropdown-menu {
                transform: scale(1, 1);
            }
        }

        .nav-left {
            float: left;
            margin-left: 15px;
        }

        .nav-right {
            float: right;

            .img-thumbnail {
                padding: 0;
                border: 0;
                width: 2rem;
                height: 2rem;
            }

            .dropdown-menu {
                left: auto;
                right: 0;

                > li {
                    width: 100%;

                    > a {
                        line-height: 1.5;
                        min-height: auto;
                        padding: 10px 15px;
                    }
                }

                ul {
                    list-style: none;
                    margin: 0;
                    padding: 0;
                    font-size: 0.87rem;
                }
            }
        }
    }

    .search-box {
        .search-icon-close {
            display: none;
        }

        &.active {
            .search-icon {
                display: none;
            }

            .search-icon-close {
                display: inline-block;
            }
        }
    }

    .search-input {
        // display: none;
        opacity: 0;
        transition: opacity 0.3s ease;

        &.active {
            opacity: 1;
            //   display: inline-block;
        }

        input {
            background-color: transparent;
            border: 0;
            box-shadow: none;
            font-size: 18px;
            height: 40px;
            margin-top: 12px;
            outline: none;
            padding: 5px;

            @include media-breakpoint-down(md) {
                width: 85px;
            }

            @include placeholder {
                color: hsl(var(--body-color), 20%);
                font-style: italic;
            }
        }
    }
}

.is-collapsed {
    .header {
        width: calc(100% - #{var(--collapsed-size)});

        @include media-breakpoint-down(lg) {
            width: 100%;
        }

        @include media-breakpoint-between(lg, xxl) {
            width: calc(100% - #{var(--offscreen-size)});
        }
    }
}

.is-collapsed {
    .header {
        width: calc(100% - #{var(--collapsed-size)});

        @include media-breakpoint-down(lg) {
            width: 100%;
        }

        @include media-breakpoint-between(lg, xxl) {
            width: calc(100% - #{var(--offscreen-size)});
        }
    }
}
</style>
