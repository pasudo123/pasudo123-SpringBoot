<template>
    <div>
        <TodoHeader></TodoHeader>
        <TodoInputWrapper></TodoInputWrapper>
        <TodoElementWrapper></TodoElementWrapper>
    </div>
</template>

<script>

    import TodoHeader from './TodoHeader';
    import TodoElementWrapper from './TodoElementWrapper';
    import TodoInputWrapper from './TodoInputWrapper';

    export default {
        name: "todoMain",
        components:{TodoHeader, TodoElementWrapper, TodoInputWrapper}
    }
</script>

<style scoped>

</style>