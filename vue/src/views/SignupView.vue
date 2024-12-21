<script setup lang="ts"></script>

<template>
    <div class="sign-container">
        <div class="sign-bg">
            <div class="sign-logo">
                <img
                    class="img-fluid"
                    src="@/assets/static/images/logo-ga.svg"
                    alt=""
                />
            </div>
        </div>

        <div class="sign-form">
            <h4 class="fw-300 c-grey-900 mB-40">회원가입</h4>
            <form>
                <div class="mb-3">
                    <label class="form-label text-normal text-dark">
                        Username
                    </label>
                    <input
                        type="text"
                        class="form-control"
                        Placeholder="John Doe"
                    />
                </div>
                <div class="mb-3">
                    <label class="form-label text-normal text-dark">
                        Email Address
                    </label>
                    <input
                        type="email"
                        class="form-control"
                        Placeholder="name@email.com"
                    />
                </div>
                <div class="mb-3">
                    <label class="form-label text-normal text-dark">
                        Password
                    </label>
                    <input
                        type="password"
                        class="form-control"
                        placeholder="Password"
                    />
                </div>
                <div class="mb-3">
                    <label class="form-label text-normal text-dark">
                        Confirm Password
                    </label>
                    <input
                        type="password"
                        class="form-control"
                        placeholder="Password"
                    />
                </div>
                <div class="mb-3">
                    <button class="btn btn-primary btn-color">가입하기</button>
                </div>
            </form>
        </div>
    </div>
</template>

<style scoped lang="scss">
.sign-container {
    display: flex;
    align-items: stretch;
    justify-content: flex-start;
    height: 100vh;
    max-width: 100%;
    margin: 0;
    padding: 0;
}
.sign-bg {
    flex: 1 1 auto;
    position: relative;
    height: 100%;
    background: url(@/assets/static/images/1703078901251.jpeg) no-repeat center
        center;
    background-size: cover;
}
.sign-logo {
    position: absolute;
    top: 50px;
    left: 50px;
    width: 120px;
    height: 120px;
    padding: 15px;
    background-color: #fff;
    border-radius: 15px;
}
.sign-form {
    flex: 0 0 auto;
    position: relative;
    height: 100%;
    width: 100%;
    min-width: 320px;
    overflow-y: auto;
    padding: 80px 40px;
    background-color: #fff;

    @media (min-width: 768px) {
        width: 33.33333333%;
    }
}
</style>
