<template>
    <div id="PaMain">
        <todo-input-wrapper></todo-input-wrapper>
        <todo-element-wrapper></todo-element-wrapper>
    </div>
</template>

<script>

    import TodoInputWrapper from './TodoInputWrapper';
    import TodoElementWrapper from './TodoElementWrapper';

    export default {
        name: "PaMain",
        components: {TodoElementWrapper, TodoInputWrapper},
    }
</script>

<style scoped>

</style>