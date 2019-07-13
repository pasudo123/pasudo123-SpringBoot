<template>
    <div class="HomeWrapper">
        <h1>Home</h1>
        <div class="list"
             v-for="link in AllLinks"
             v-bind:key="link.id">
            <a @click="convertView(link)">{{link.name}}</a>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Home",
        data() {
            return {
                AllLinks: [],
            }
        },
        methods: {
            setLink() {
                let array = ["todo", "album"];

                for (let i = 0; i < array.length; i++) {
                    this.AllLinks.push({
                        id: i,
                        link: "/" + array[i],
                        name: array[i]
                    });
                }
            },
            convertView(link){
                this.$router.push({path: link.link})
            }
        },
        created() {
            this.setLink();
        }
    }
</script>

<style scoped>
    div.HomeWrapper {
        margin-top: 20px;
        text-align: center;
    }

    div.list{
        margin-top: 5px;
        margin-bottom: 5px;
    }

</style>