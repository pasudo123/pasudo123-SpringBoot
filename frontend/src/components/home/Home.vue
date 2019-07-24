<template>
    <div id="home">

        <div class="list"
             v-for="link in AllLinks"
             v-bind:key="link.id">

            <a class="linkBtn" @click="convertView(link)">{{link.name}}</a>
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
                let array = ["Todo", "Album"];

                for (let i = 0; i < array.length; i++) {
                    this.AllLinks.push({
                        id: i,
                        link: "/" + array[i],
                        name: array[i]
                    });
                }
            },
            convertView(link) {
                let path = link.link.toLowerCase();
                this.$router.push({path: path})
            }
        },
        created() {
            this.setLink();
        }
    }
</script>

<style scoped>
    div#home {
        margin-top: 20px;
        text-align: center;
    }

    div.list {
        margin-top: 10px;
        margin-bottom: 10px;
    }

    a.linkBtn{
        width:80px;
        font-size: 16px;
        display:inline-block;
        color: black;
        border-bottom: 1px solid transparent;
    }

    a.linkBtn:hover{
        cursor: pointer;
        color: red;
        border-bottom: 1px solid red;
    }

</style>