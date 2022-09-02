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
            //存放请求目标地址
            hesuan_result_url: 'findResultById',
            history_url: 'findAllReturn_mess',
            notice_url:'findAllNotice',
            true_info_url:'findUserByName',
            //核酸结果暂存
            hesuan_result: [],
            //风险地旅居史
            history: [],
            //公告
            notice: [],
            //身份信息
            id_info:[],
        },
        methods: {
            // 控制左边部分显示什么
            show_result: function () {
                this.get_hesuan_check_result();
                if (this.is_result_info_show === true) {
                    this.is_result_show = true;
                    this.is_history_show = false;
                    this.is_result_info_show = false;
                } else {
                    this.is_result_show = false;
                    this.is_history_show = false;
                    this.is_result_info_show = true;
                }


            },
            show_history: function () {
                this.get_history();
                if (this.is_history_show === true) {
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
            get_hesuan_check_result: function () {
                let that = this;
                axios.post(this.hesuan_result_url,{
                    id:1,
                }).then(function (res) {
                    // 将获取到的数据进行操作
                    // console.log(response.data);
                    for (var i = 0; i <= 8; i++) {
                        // 将结果放到数组里面，少放点
                        // console.log(res);
                        that.hesuan_result = res.data;
                    }
                    // 打印一下看看咯
                    // console.log(that.hesuan_result);
                })
            },

            //获取旅居史
            get_history: function () {
                let that = this;
                axios.post(this.history_url, {
                    //给服务器的参数
                }).then(function (res) {
                    //将获取到的数据存入数组
                    for (var i = 0; i < 8; i++) {
                        that.history = res.data;
                    }
                    console.log(res);
                    // 打印一下试试看
                    console.log(that.history);
                })
            },

            //获取公告
            get_notice: function () {
                var that = this;
                axios.post(this.notice_url, {
                    //给服务器的参数
                }).then(function (res) {
                    //将获取到的数据存入数组
                    for (var i = 0; i < 8; i++) {
                        that.notice = res.data;
                    }
                    // 打印一下试试看
                    // console.log(that.notice);
                })
            },

            //获取真实姓名等信息

            get_true_info: function () {
                var that = this;
                axios.post(this.true_info_url, {
                    //给服务器的参数
                    name:'lisi',
                }).then(function (res) {
                    //将获取到的数据存入数据
                    that.id_info = res.data;
                    // that.id_num = res.data.idcard;
                    // 打印一下试试看
                    console.log(that.id_info);
                })
            }
        },
    mounted(){
            this.get_notice();
            this.get_true_info();
    },
    }
);
