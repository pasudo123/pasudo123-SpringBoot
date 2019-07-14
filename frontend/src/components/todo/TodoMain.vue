<template>
    <div>
        <TodoHeader></TodoHeader>
        <TodoInput></TodoInput>
        <TodoElement></TodoElement>
    </div>
</template>

<script>

    import TodoHeader from './TodoHeader';
    import TodoElement from './TodoElement';
    import TodoInput from './TodoInput';

    export default {
        name: "todoMain",
        components:{TodoHeader, TodoElement, TodoInput}
    }
</script>

<style scoped>

</style>