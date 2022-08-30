var vm = new Vue({
        el: '#main_info',
        data: {
            is_result_show: true,
            is_result_info_show: false,
            is_history_show: false,
        },
        methods: {
            show_result: function() {

                this.is_result_show = !this.is_result_show;
                this.is_history_show = false;
                this.is_result_info_show = !this.is_result_info_show;

            },
            show_history: function() {
                if (this.is_result_info_show == true) {
                    this.is_result_info_show = !this.is_result_info_show;
                    this.is_result_show = false;
                    this.is_history_show = true;
                } else {
                    this.is_result_info_show = !this.is_result_info_show;
                    this.is_result_show = false;
                    this.is_history_show = false;
                }
            }
        },
    }

)