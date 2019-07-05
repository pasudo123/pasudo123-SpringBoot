<template>
    <div id="PaMain">
        <PaHeader></PaHeader>

        <!-- 라우터가 컴포넌트를 그려주기 위한 부분 -->
        <router-view></router-view>
    </div>
</template>

<script>

    import PaHeader from './PaHeader'
    import TodoMain from './todo/TodoMain'

    export default {
        name: "PaMain",
        components: {PaHeader, TodoMain}
    }
</script>

<style scoped>
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
    }
    body {
        font-family: Arial, Helvetica, sans-serif;
        line-height: 1.4;
    }
</style>