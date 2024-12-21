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
                <div class="peers ai-c fxw-nw">
                    <div class="peer peer-greed">
                        <a class="sidebar-link td-n" href="index.html">
                            <div class="peers ai-c fxw-nw">
                                <div class="peer">
                                    <RouterLink to="/" class="logo">
                                        <img
                                            src="@/assets/static/images/logo-ga.svg"
                                            alt="로고"
                                        />
                                    </RouterLink>
                                </div>
                                <div class="peer peer-greed">
                                    <h5 class="lh-1 mB-0 logo-text">
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
                                class="td-n"
                                @click="toggleSidebar"
                            >
                                <i class="ti-arrow-circle-left"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <ul class="sidebar-menu scrollable pos-r">
                <li class="nav-item mT-30 actived">
                    <RouterLink to="/" class="sidebar-link">
                        <span class="icon-holder">
                            <i class="c-deep-orange-500 ti-home"></i>
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
                            <i class="c-brown-500 ti-stats-up"></i>
                        </span>
                        <span class="title">종목</span>
                        <span class="arrow">
                            <i class="ti-angle-right"></i>
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
                            <i class="c-blue-500 ti-world"></i>
                        </span>
                        <span class="title">마켓</span>
                        <span class="arrow">
                            <i class="ti-angle-right"></i>
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
                            <i class="c-purple-500 ti-pie-chart"></i>
                        </span>
                        <span class="title">포트폴리오</span>
                        <span class="arrow">
                            <i class="ti-angle-right"></i>
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
                            <i class="c-pink-500 ti-bell"></i>
                        </span>
                        <span class="title">알람</span>
                    </RouterLink>
                </li>
                <li class="nav-item">
                    <RouterLink to="/" class="sidebar-link">
                        <span class="icon-holder">
                            <i class="c-light-blue-500 ti-user"></i>
                        </span>
                        <span class="title">프로필 설정</span>
                    </RouterLink>
                </li>
                <li class="nav-item">
                    <RouterLink to="/signin" class="sidebar-link">
                        <span class="icon-holder">
                            <i class="c-gray-500 ti-user"></i>
                        </span>
                        <span class="title">로그인</span>
                    </RouterLink>
                </li>
                <li class="nav-item">
                    <RouterLink to="/signup" class="sidebar-link">
                        <span class="icon-holder">
                            <i class="c-gray-500 ti-user"></i>
                        </span>
                        <span class="title">회원가입</span>
                    </RouterLink>
                </li>
            </ul>
        </div>
    </div>
</template>

<style scoped></style>
