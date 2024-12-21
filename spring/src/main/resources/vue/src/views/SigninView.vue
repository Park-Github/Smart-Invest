<script setup lang="ts"></script>

<template>
    <div class="container-fluid sign-container">
        <form class="form sign-form">
            <h2 class="form-header">
                Smart Invest 에 오신 것을<br /> 환영합니다!
            </h2>

            <div class="form-body">
                <div class="mb-3">
                    <label class="form-label required">
                        이메일
                    </label>
                    <input
                        type="email"
                        class="form-control form-control-lg"
                        placeholder="이메일을 입력하세요."
                        required
                    />
                </div>
                <div class="mb-3">
                    <label class="form-label required">
                        비밀번호
                    </label>
                    <input
                        type="password"
                        class="form-control form-control-lg"
                        placeholder="비밀번호를 입력하세요."
                        required
                    />
                </div>
                <div class="form-check mb-3">
                    <input
                        class="form-check-input"
                        type="checkbox"
                        value=""
                        id="flexCheckDefault"
                    />
                    <label class="form-check-label" for="flexCheckDefault">
                        로그인 정보 저장
                    </label>
                </div>
                <button type="button" class="btn btn-primary w-100 mb-5">
                    로그인
                </button>
                
                <div class="row row-cols-xl-2 g-2 mb-5">
                    <div class="col">
                        <button
                            type="button"
                            class="btn btn-sns btn-kakao"
                            onclick="location.href='/oauth2/authorization/kakao'"
                        >
                            <img src="@/assets/img/kakao.png" alt="Kakao">
                            카카오로 계속하기
                        </button>
                    </div>
                    <div class="col">
                        <button
                            type="button"
                            class="btn btn-sns btn-naver"
                            onclick="location.href='/oauth2/authorization/naver'"
                        >
                            <img src="@/assets/img/naver.png" alt="Naver" />
                            네이버로 계속하기
                        </button>
                    </div>
                    <div class="col">
                        <button
                            type="button"
                            class="btn btn-sns btn-apple"
                            onclick="location.href='/oauth2/authorization/apple'"
                        >
                            <img src="@/assets/img/apple.png" alt="Apple" />
                            Apple로 계속하기
                        </button>
                    </div>
                    <div class="col">
                        <button
                            type="button"
                            class="btn btn-sns btn-google"
                            onclick="location.href='/oauth2/authorization/google'"
                        >
                            <img src="@/assets/img/google.png" alt="Google" />
                            Google로 계속하기
                        </button>
                    </div>
                </div>
            </div>

            <div class="form-footer">
                <button type="button" class="btn-link">아이디 찾기</button>
                <span class="vr align-self-center"></span>
                <button type="button" class="btn-link">비밀번호 찾기</button>
                <span class="vr align-self-center"></span>
                <RouterLink to="/signup" type="button" class="btn-link">회원가입</RouterLink>
            </div>
        </form>
    </div>
</template>

<style scoped lang="scss">
.sign-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
    min-height: 0;
    background-color: #d5d5d5;
    // background-color: #21D4FD;
	// background-image: linear-gradient(19deg, #21D4FD 0%, #B721FF 100%);
    @include media-breakpoint-down(md) {
        padding: 0;
    }
}

.sign-form {
    overflow: hidden;
    max-width: 500px;
    border-radius: 1rem;
    background-color: #fff;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    transition: all .32s ease-in;

    .form-header {
        padding: 4rem 4rem 1rem;
        font-size: 2.1rem;
        font-weight: 600;
        letter-spacing: -0.5px;
    }

    .form-body {
        overflow-y: auto;
        padding: 2rem 4rem;
    }

    .form-footer {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        align-items: center;
        gap: 0.25rem;
        padding: 1rem 4rem 2rem;
    }

    @include media-breakpoint-down(md) {
        box-shadow: none;
        border-radius: 0;
        max-width: 100%;
        width: 100%;
        height: 100%;
    }

    @include media-breakpoint-up(lg) {
        .form-footer {
            gap: 0.5rem;
        }
    }
}

.btn {
    &-link {
        border: 0;
        background-color: transparent;
        text-decoration: none;
        color: #71747c;
        font-size: 0.875rem;
        font-weight: 600;
        cursor: pointer;
    }

    &-sns {
        display: inline-flex;
        justify-content: center;
        align-items: center;
        gap: 10px;
        border-radius: 0.5rem;
        white-space: nowrap;
        width: 100%;
        font-size: 0.875rem;
        font-weight: 600;

        img {
            max-width: 100%;
            height: 18px;
        }
    }

    &-kakao {
        color: #232433;
        border-color: #fee500;
        background-color: #fee500;
    }

    &-naver {
        color: #fff;
        border: 1px solid #03c75a;
        background-color: #03c75a;
    }

    &-google,
    &-apple {
        color: #232433;
        border-color: #d4d8e2;
        background-color: #fff;
    }
}
</style>