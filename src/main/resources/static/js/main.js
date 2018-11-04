Vue.component('todo-item', {
    props: ['todo'],
    template: '<li>{{ todo.text }}</li>'
})

var app7 = new Vue({
    el: '#app-7',
    data: {
        groceryList: [
            { id: 0, text: 'Овощи' },
            { id: 1, text: 'Сыр' },
            { id: 2, text: 'Что там ещё люди едят?' }
        ]
    }
})

var app = new Vue({
    el: '#app',
    data: {
        endpoint: '/controller',
        posts: [],
    },
    methods: {
        getSome: function () {
            this.$http.get(this.endpoint).then(function (response) {
                this.posts = response.data
                console.log(response)
            }, function (error) {
                
            })
        }
    },
    created: function() {
        this.getSome()
    }
});