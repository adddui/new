var vm = new Vue({
        el: '#index',
        data: {
            // 显示控制参数
            is_result_show: true,
            is_result_info_show: false,
            is_history_show: false,
            //绑定参数
            true_name: '张三', //真实姓名
            id_num: '510000000000000000', //身份证号

            url: '', //存放请求目标地址
            //核酸结果暂存
            hesuan_result: [
                { check_time: '2022-2-2', check_organ: '成都理工大学校医院', check_result: '阴' },
                { check_time: '2022-2-3', check_organ: '成都理工大学校医院', check_result: '阴' },
                { check_time: '2022-2-4', check_organ: '成都理工大学校医院', check_result: '阴' },
                { check_time: '2022-2-5', check_organ: '成都理工大学校医院', check_result: '阴' },
            ],
            //风险地旅居史
            history: [
                { area: '成都理工大学', level: '中风险', arrive_time: '3', leave_time: '4' },
                { area: '成都理工大学', level: '中风险', arrive_time: '3', leave_time: '4' },
                { area: '成都理工大学', level: '中风险', arrive_time: '3', leave_time: '4' },
                { area: '成都理工大学', level: '中风险', arrive_time: '3', leave_time: '4' },

            ],
            //公告
            notice: [
                { title: '疫情防控，人人有责！', time: '2022-8-31' },
                { title: '疫情防控，人人有责！', time: '2022-8-31' },
                { title: '疫情防控，人人有责！', time: '2022-8-31' },
                { title: '疫情防控，人人有责！', time: '2022-8-31' },
                { title: '疫情防控，人人有责！', time: '2022-8-31' },
            ]

        },
        methods: {
            // 控制左边部分显示什么
            show_result: function() {
                if (this.is_result_info_show == true) {
                    this.is_result_show = true;
                    this.is_history_show = false;
                    this.is_result_info_show = false;
                } else {
                    this.is_result_show = false;
                    this.is_history_show = false;
                    this.is_result_info_show = true;
                }


            },
            show_history: function() {
                if (this.is_history_show == true) {
                    this.is_result_info_show = false;
                    this.is_result_show = true;
                    this.is_history_show = false;
                } else {
                    this.is_result_info_show = false;
                    this.is_result_show = false;
                    this.is_history_show = true;
                }
            },


            // 获取核酸检测结果
            get_hesuan_check_result: function() {
                axios.post(this.url, {
                    //给服务器的参数

                }).then(res => function() {
                    // 将获取到的数据进行操作
                    this.hesuan_result.push(res.data.result);
                })
            },

            //获取旅居史
            get_history: function() {
                axios.post(this.url, {
                    //给服务器的参数
                }).then(res => function() {
                    //将获取到的数据存入数组
                    this.history.push(res.data.result);
                })
            },

            //获取公告

            get_notice: function() {
                axios.post(this.url, {
                    //给服务器的参数
                }).then(res => function() {
                    //将得到的数据存入数组
                    this.notice.push(res.data.result);
                })
            },

            //获取真实姓名等信息

            get_true_info: function() {
                axios.post(this.url, {
                    //给服务器的参数
                }).then(res => function() {
                    //将得到的数据存入
                    this.true_name = res.data.true_name;
                    this.id_num = res.data.id_num;
                })
            }


        },
    }

)