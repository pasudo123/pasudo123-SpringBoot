<template>
    <div class="PaMain">
        <PaHeader></PaHeader>

        <!-- 라우터가 컴포넌트를 그려주기 위한 부분 -->
        <router-view></router-view>
    </div>
</template>

<script>

    import PaHeader from './PaHeader'

    export default {
        name: "PaMain",
        components: {PaHeader}
    }
</script>

<style>
    * {
        box-sizing: border-box;
        margin: 0 auto;
        padding: 0;
    }
</style>