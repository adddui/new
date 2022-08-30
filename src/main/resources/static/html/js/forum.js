var vm = new Vue({
        el: '#app',
        data: {
            is_notice_show: true,
            is_edit_show: false,
        },
        methods: {
            show_edit: function() {
                this.is_edit_show = !this.is_edit_show;
                this.is_notice_show = !this.is_notice_show;
            }
        },
    }

)