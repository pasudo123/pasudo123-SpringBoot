<template>
    <header class="header">
        <h2>PASUDO123 Real World</h2>

        <div class="nav">
            <router-link to="/">Home</router-link> |
            <router-link to="/about">About</router-link>
        </div>
    </header>
</template>

<script>
    export default {
        name: "PaHeader",
    }
</script>

<style scoped>
    header.header {
        background: #333;
        color: #fff;
        text-align: center;
        padding: 15px;
        font-family: Consolas;
    }

    div.nav{
        margin-top:7px;
    }

    header.header a{
        color: #fff;
        padding: 0px 3px;
        text-decoration: none;
        font-family: Consolas;
    }
</style>