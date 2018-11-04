var app = new Vue({
    el: '#app',
    data: {
        endpoint: '/controller',
        posts: []
    },
    methods: {
        getSome: function () {
            this.$http.get(this.endpoint).then(function (response) {
                this.posts = response.data
                // console.log(response)
            }, function (error) {

            })
        }
    },
    created: function() {
        this.getSome()
    }
});