<script setup lang="ts">
import { onMounted, inject } from "vue";

onMounted(() => {});

// Inject the provided toggle function
const toggleSidebar = inject("toggleSidebar");
</script>

<template>
    <div class="sidebar">
        <div class="sidebar-inner">
            <div class="sidebar-logo">
                <div class="peers align-items-center fw-normal">
                    <div class="peer peer-greed">
                        <a class="sidebar-link text-decoration-none" href="index.html">
                            <div class="peers align-items-center fw-normal">
                                <div class="peer">
                                    <RouterLink to="/" class="logo">
                                        <img
                                            src="@/assets/img/logo.svg"
                                            alt="로고"
                                        />
                                    </RouterLink>
                                </div>
                                <div class="peer peer-greed">
                                    <h5 class="lh-1 mb-0 logo-text">
                                        Smart Invest
                                    </h5>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="peer">
                        <div class="mobile-toggle sidebar-toggle">
                            <a
                                href="javascript:void(0);"
                                class="text-decoration-none"
                                @click="toggleSidebar"
                            >
                                <span class="material-symbols-outlined" style="transform: rotate(180deg);">expand_circle_right</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <ul class="sidebar-menu scrollable position-relative">
                <li class="nav-item mt-4 actived">
                    <RouterLink to="/" class="sidebar-link">
                        <span class="icon-holder">
                            <span class="material-symbols-outlined">home</span>
                        </span>
                        <span class="title">홈</span>
                    </RouterLink>
                </li>
                <li class="nav-item dropdown">
                    <a
                        href="javascript:void(0);"
                        class="dropdown-toggle"
                        data-bs-toggle="dropdown"
                        aria-expanded="false"
                    >
                        <span class="icon-holder">
                            <span class="material-symbols-outlined">monitoring</span>
                        </span>
                        <span class="title">종목</span>
                        <span class="arrow">
                            <span class="material-symbols-outlined">keyboard_arrow_right</span>
                        </span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a class="sidebar-link" href="a.html">종목 검색</a>
                        </li>
                        <li>
                            <a class="sidebar-link" href="b.html">
                                기술적 분석
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a
                        href="javascript:void(0);"
                        class="dropdown-toggle"
                        data-bs-toggle="dropdown"
                        aria-expanded="false"
                    >
                        <span class="icon-holder">
                            <span class="material-symbols-outlined">globe</span>
                        </span>
                        <span class="title">마켓</span>
                        <span class="arrow">
                            <span class="material-symbols-outlined">keyboard_arrow_right</span>
                        </span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a class="sidebar-link" href="a.html">뉴스</a>
                        </li>
                        <li>
                            <a class="sidebar-link" href="b.html">인덱스</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a
                        class="dropdown-toggle"
                        href="javascript:void(0);"
                        data-bs-toggle="dropdown"
                        aria-expanded="false"
                    >
                        <span class="icon-holder">
                            <span class="material-symbols-outlined">pie_chart</span>
                        </span>
                        <span class="title">포트폴리오</span>
                        <span class="arrow">
                            <span class="material-symbols-outlined">keyboard_arrow_right</span>
                        </span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a class="sidebar-link" href="a.html">
                                자산배분 만들기
                            </a>
                        </li>
                        <li>
                            <a class="sidebar-link" href="b.html">
                                내맘대로 만들기
                            </a>
                            <a class="sidebar-link" href="c.html">
                                포트폴리오 관리
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <RouterLink to="/" class="sidebar-link">
                        <span class="icon-holder">
                            <span class="material-symbols-outlined">notifications</span>
                        </span>
                        <span class="title">알람</span>
                    </RouterLink>
                </li>
                <li class="nav-item">
                    <RouterLink to="/" class="sidebar-link">
                        <span class="icon-holder">
                            <span class="material-symbols-outlined">person</span>
                        </span>
                        <span class="title">프로필 설정</span>
                    </RouterLink>
                </li>
                <li class="nav-item">
                    <RouterLink to="/signin" class="sidebar-link">
                        <span class="icon-holder">
                            <span class="material-symbols-outlined">login</span>
                        </span>
                        <span class="title">로그인</span>
                    </RouterLink>
                </li>
                <li class="nav-item">
                    <RouterLink to="/signup" class="sidebar-link">
                        <span class="icon-holder">
                            <span class="material-symbols-outlined">id_card</span>
                        </span>
                        <span class="title">회원가입</span>
                    </RouterLink>
                </li>
            </ul>
        </div>
    </div>
</template>

<style scoped lang="scss">
.sidebar {
    background-color: #fff;
    bottom: 0;
    overflow: hidden;
    position: fixed;
    top: 0;
    transition: all 0.2s ease;
    width: var(--offscreen-size);
    z-index: 1000;

    ul {
        list-style-type: none;
    }

    @include media-breakpoint-between(lg, xxl) {
        width: var(--collapsed-size);

        .sidebar-inner {
            .sidebar-logo {
                border-bottom: 1px solid transparent;
                padding: 0;

                a {
                    .logo {
                        background-position: center center;
                        width: var(--collapsed-size);
                    }
                }
            }

            .sidebar-menu {
                overflow-x: hidden;

                > li {
                    > a {
                        .title {
                            display: none;
                        }
                    }
                }

                li {
                    &.dropdown {
                        .arrow {
                            opacity: 0;
                        }

                        ul.dropdown-menu.show {
                            display: none !important;
                        }

                        // &.open {
                        //   ul.dropdown-menu {
                        //     display: none !important;
                        //   }
                        // }
                    }
                }
            }
        }

        &:hover {
            width: var(--offscreen-size);

            .sidebar-inner {
                .sidebar-logo {
                    border-bottom: 1px solid var(--border-color);
                    padding: 0 20px;
                }

                .sidebar-menu {
                    > li {
                        > a {
                            .title {
                                display: inline-block;
                            }
                        }
                    }

                    li {
                        &.dropdown {
                            .arrow {
                                opacity: 1;
                            }
                        }

                        > ul.dropdown-menu.show {
                            display: block !important;
                        }

                        // &.open {
                        //   > ul.dropdown-menu {
                        //     display: block !important;
                        //   }
                        // }
                    }
                }
            }
        }
    }

    @include media-breakpoint-down(lg) {
        left: - var(--offscreen-size);
        width: calc(#{var(--offscreen-size)} - 30px);
    }
}

.sidebar-inner {
    position: relative;
    height: 100%;
}

.sidebar-logo {
    border-bottom: 1px solid rgba(0, 0, 0, 0.0625);
    border-right: 1px solid rgba(0, 0, 0, 0.0625);
    line-height: 0;
    padding: 0 20px;
    transition: all 0.2s ease;

    a {
        display: inline-block;
        width: 100%;

        .logo {
            background-position: center left;
            background-repeat: no-repeat;
            display: inline-block;
            min-height: calc(#{var(--header-height)} - 1px);
            width: 100%;
            width: 70px;

            img {
                width: 50px;
                height: 40px;
                margin: 10px;
            }
        }

        .logo-text {
            // color: $grey-900;
            white-space: nowrap;
            letter-spacing: -0.5px;
        }
    }

    .mobile-toggle {
        display: inline-block;
        float: right;
        font-size: 18px;
        line-height: calc(#{var(--header-height)} - 1px);

        a {
            color: var(--text-color);
        }

        @include media-breakpoint-up(xl) {
            display: none;
        }

        // @include media-breakpoint-down(lg) {
        //     display: inline-block;
        // }

        // @include media-breakpoint-between(lg, xxl) {
        //     display: none;
        // }
    }
}

.sidebar-menu {
    @include clearfix;
    border-right: 1px solid rgba(0, 0, 0, 0.0625);
    height: calc(100vh - #{var(--header-height)});
    list-style: none;
    margin: 0;
    overflow: auto;
    padding: 0;
    position: relative;

    .dropdown-toggle::after {
        display: none;
    }

    .sidebar-link {
        &.actived::before {
            background: $md-blue-500;
            border-radius: 50%;
            content: "";
            display: block;
            height: 8px;
            left: -4px;
            position: absolute;
            top: calc(50% - 4px);
            width: 8px;
        }
    }

    li {
        position: relative;

        &.dropdown {
            .arrow {
                font-size: 10px;
                position: absolute;
                right: 30px;
                color: #aaa;
                transition: all 0.05s ease-in;

                @include media-breakpoint-down(lg) {
                    right: 25px;
                }
            }

            > .dropdown-toggle.show {
                color: var(--dark-color);

                .icon-holder {
                    color: var(--info-color);
                }

                > .arrow {
                    transform: rotate(90deg);
                }
            }

            > .dropdown-menu.show {
                display: block;

                .dropdown-menu {
                    padding-left: 20px;
                }

                .arrow {
                    line-height: 25px;
                }
            }
            // &.open {
            //   > a {
            //     color: var(--dark-color)

            //     .icon-holder {
            //       color: var(--info-color)
            //     }

            //     > .arrow {
            //       transform: rotate(90deg);
            //     }
            //   }

            //   > .dropdown-menu {
            //     display: block;

            //     .dropdown-menu {
            //       padding-left: 20px;
            //     }

            //     .arrow {
            //       line-height: 25px;
            //     }
            //   }
            // }
        }

        /* dropdown floating style off */
        // .dropdown-menu {
        //   position: relative !important;
        //   transform: translateY(0) !important;
        // }

        a {
            color: var(--text-color);
            transition: all 0.3s ease;

            &:hover,
            &:focus {
                color: var(--dark-color);
                text-decoration: none;

                .icon-holder {
                    color: var(--info-color);
                }
            }
        }

        .dropdown-toggle.show {
            color: var(--dark-color);

            .icon-holder {
                color: var(--info-color);
            }

            > .arrow {
                transform: rotate(90deg);
            }
        }

        .dropdown-menu.show {
            display: block;
            position: relative !important;
            transform: translate(0) !important;

            .dropdown-menu {
                padding-left: 20px;
            }

            .arrow {
                line-height: 25px;
            }
        }
    }

    > li {
        &.dropdown {
            ul {
                &.dropdown-menu {
                    background-color: transparent;
                    border-radius: 0;
                    border: 0;
                    box-shadow: none;
                    float: none;
                    padding-left: 50px;
                    padding-top: 0;
                    position: relative;
                    width: 100%;

                    > li {
                        > a {
                            display: block;
                            padding: 10px 15px;

                            &:hover,
                            &:focus {
                                background-color: transparent;
                                color: var(--dark-color);
                            }
                        }

                        &.actived {
                            a {
                                color: var(--dark-color);
                            }
                        }
                    }
                }
            }
        }

        > a {
            display: block;
            font-size: 15px;
            font-weight: 500;
            padding: 5px 15px;
            position: relative;
            white-space: nowrap;

            .icon-holder {
                border-radius: 6px;
                display: inline-block;
                font-size: 17px;
                height: 35px;
                left: 0;
                line-height: 35px;
                margin-right: 14px;
                position: relative;
                text-align: center;
                transition: all 0.3s ease;
                width: 35px;
            }
        }
    }
}

.is-collapsed {
    .sidebar {
        @include media-breakpoint-up(xxl) {
            width: var(--collapsed-size);

            .sidebar-inner {
                .sidebar-logo {
                    border-bottom: 1px solid transparent;
                    padding: 0;
                }

                .sidebar-menu {
                    overflow-x: hidden;

                    > li {
                        > a {
                            .title {
                                display: none;
                            }
                        }
                    }

                    li {
                        &.dropdown {
                            .arrow {
                                opacity: 0;
                            }

                            ul.dropdown-menu.show {
                                display: none !important;
                            }

                            // &.open {
                            //   ul.dropdown-menu {
                            //     display: none !important;
                            //   }
                            // }
                        }
                    }
                }
            }

            &:hover {
                width: var(--offscreen-size);

                .sidebar-inner {
                    .sidebar-logo {
                        border-bottom: 1px solid var(--border-color);
                        padding: 0 20px;
                    }

                    .sidebar-menu {
                        > li {
                            > a {
                                .title {
                                    display: inline-block;
                                }
                            }
                        }

                        li {
                            &.dropdown {
                                .arrow {
                                    opacity: 1;
                                }
                            }

                            ul.dropdown-menu.show {
                                display: block !important;
                            }

                            // &.open {
                            //   > ul.dropdown-menu {
                            //     display: block !important;
                            //   }
                            // }
                        }
                    }
                }
            }
        }

        @include media-breakpoint-between(lg, xxl) {
            width: var(--offscreen-size);

            .sidebar-inner {
                .sidebar-logo {
                    border-bottom: 1px solid var(--border-color);
                    padding: 0 20px;

                    > a {
                        .logo {
                            background-position: center left;
                            width: 150px;
                        }
                    }
                }

                .sidebar-menu {
                    > li {
                        > a {
                            .title {
                                display: inline-block;
                            }
                        }
                    }

                    li {
                        &.dropdown {
                            .arrow {
                                opacity: 1;
                            }
                        }

                        ul.dropdown-menu.show {
                            display: block !important;
                        }

                        // &.open {
                        //   > ul.dropdown-menu {
                        //     display: block !important;
                        //   }
                        // }
                    }
                }
            }
        }

        @include media-breakpoint-down(lg) {
            left: 0;
        }
    }
}
</style>
