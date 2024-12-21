<script setup lang="ts"></script>

<template>
    <div class="container-fluid sign-container">
        <form class="form sign-form">
            <h2 class="form-header">
                회원가입 
            </h2>
            <div class="form-body">
                <h3 class="c-grey-900 mb-4">가입정보를 입력해주세요.</h3>
                <div class="mb-3">
                    <label class="form-label required">
                        이메일
                    </label>
                    <div class="row g-2">
                        <div class="col">
                            <input
                                type="text"
                                class="form-control form-control-lg"
                                placeholder="name@email.com"
                            />
                        </div>
                        <div class="col-auto">
                            <button type="button" class="btn btn-lg btn-light">인증번호 받기</button>
                        </div>
                    </div>
                </div>
                <div class="mb-3">
                    <label class="form-label required">
                        인증번호
                    </label>
                    <div class="row g-2">
                        <div class="col">
                            <input
                                type="text"
                                class="form-control form-control-lg" placeholder="인증번호를 입력해주세요." required
                            />
                        </div>
                        <div class="col-auto">
                            <button type="button" class="btn btn-lg btn-light">인증번호 입력</button>
                        </div>
                    </div>
                </div>
                <div class="mb-3">
                    <label class="form-label required">
                        비밀번호
                    </label>
                    <input
                        type="password"
                        class="form-control form-control-lg"
                        placeholder="비밀번호를 입력해주세요." required
                    />
                </div>
                <div class="mb-3">
                    <label class="form-label required">
                        비밀번호 확인
                    </label>
                    <input
                        type="password"
                        class="form-control form-control-lg"
                        placeholder="비밀번호를 확인해주세요." required
                    />
                    <div class="form-text">영문, 숫자, 특수문자 혼합 8-15 자리</div>
                </div>
                <div class="mb-3">
                    <label class="form-label required">
                        휴대폰번호
                    </label>
                    <div class="row g-2">
                        <div class="col">
                            <input
                                type="text"
                                class="form-control form-control-lg" placeholder="휴대폰번호를 입력해주세요." required
                            />
                        </div>
                        <div class="col-auto">
                            <button type="button" class="btn btn-lg btn-light">인증번호 받기</button>
                        </div>
                    </div>
                </div>
                <div class="mb-4">
                    <label class="form-label required">
                        인증번호
                    </label>
                    <div class="row g-2">
                        <div class="col">
                            <input
                                type="text"
                                class="form-control form-control-lg" placeholder="인증번호를 입력해주세요." required
                            />
                        </div>
                        <div class="col-auto">
                            <button type="button" class="btn btn-lg btn-light">인증번호 입력</button>
                        </div>
                    </div>
                </div>
                <div class="mb-3">
                    <button type="submit" class="btn btn-lg btn-primary w-100">가입하기</button>
                </div>
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
        padding: 4rem 4rem 0;
        font-size: 2.1rem;
        font-weight: 600;
        letter-spacing: -0.5px;
    }

    .form-body {
        overflow-y: auto;
        padding: 2rem 4rem;
    }

    @include media-breakpoint-down(md) {
        box-shadow: none;
        border-radius: 0;
        max-width: 100%;
        width: 100%;
        height: 100%;
    }
}

.form-text {
    position: relative;
    margin-top: 0.5rem;
    padding-left: 1rem;
    font-size: 0.75rem;
    color: #93959c;

    &::before {
        content: "·";
        position: absolute;
        top: 0;
        left: 0;
    }
}
</style>
