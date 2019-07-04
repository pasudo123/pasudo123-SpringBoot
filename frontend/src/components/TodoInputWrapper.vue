
<template>
    <div>
        <v-form>
            <v-container>
                <v-layout row wrap>
                    <v-flex>
                        <v-text-field
                                v-model='todoText'
                                label="할 일 작성하기"
                                solo-inverted
                        ></v-text-field>
                    </v-flex>
                </v-layout>
            </v-container>
        </v-form>
    </div>
</template>

<script>
    export default {
        name: "TodoInputWrapper",
        data: function() {
            return{
                todoText: '',
            }
        },
        methods: {

        },

    }
</script>

<style scoped>

</style>