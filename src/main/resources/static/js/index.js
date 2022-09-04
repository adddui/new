var vm = new Vue({
    el: '#index',
    data: {
        // 显示控制参数
        is_result_show: true,
        is_result_info_show: false,
        is_history_show: false,
        //绑定参数
        name: '张三', // 昵称
        // 这个是健康码的图捏
        src: './img/green.png',

        // 存一下token捏
        token: localStorage.token,
        // 存一下uid捏
        uid: localStorage.uid,
        //核酸结果暂存
        sampleTime: '',
        checkTime: '',
        oid: '',
        organ_name: '',
        resultStatus: '',
        //风险地旅居史
        history: '',
        //公告
        notice: [],
        // 风险等级
        level: '健康状态...',
        // 样式
        style: 'color:grey',
        // class
        detail: 'detail_hidden'
    },
    methods: {
        // 控制左边部分显示什么
        show_result: function() {
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
        show_history: function() {
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
        get_hesuan_check_result: function() {
            let that = this;
            axios.post('authority/findResultByUid', {
                // 携带的参数
                uid: that.uid,
            }, {
                headers: {
                    token: that.token
                }
            }).then(function(res) {
                // 打印一下看看咯
                // 存储查询结果
                // 采样时间
                that.sampleTime = res.data.sampleTime;
                // 检查时间
                that.checkTime = res.data.checkTime;
                // 检查机构
                that.oid = res.data.oid;
                that.get_organ_name();
                // 检测结果
                that.resultStatus = res.data.resultStatus;

                if (that.resultStatus === '阴') {
                    that.level = '绿码: 健康状态为低风险';
                    that.style = 'color:green;font-weight:bold;font-size:15px';
                    that.src = './img/green.png';
                } else if (that.resultStatus === '阳') {
                    that.level = '红码: 健康状态为高风险';
                    that.style = 'color:red;font-weight:bold;font-size:15px';
                    that.src = './img/red.png';
                } else if (that.resultStatus === '') {
                    that.level = "黄码：健康状态为中风险";
                    that.style = 'color:yellow;font-weight:bold;font-size:15px';
                    that.src = './img/yellow.png';
                }
            })
        },

        //根据oid查询机构名称
        get_organ_name: function() {
            var that = this;
            axios.post('findOrganById', {
                id: that.oid,
            }, {
                headers: {
                    token: this.token
                }
            }).then(function(res) {
                that.organ_name = res.data.organName;
            })
        },

        //获取旅居史
        get_history: function() {
            let that = this;
            axios.post('authority/findUserById', {
                //给服务器的参数
                uid: that.uid,
            }, {
                headers: {
                    token: that.token
                }
            }).then(function(res) {
                //将获取到的数据存入数组
                that.history = res.data.trace;
                that.name = res.data.name
            })
        },

        //获取公告
        get_notice: function() {
            var that = this;
            axios.post('findAllNotice', {
                //给服务器的参数
                uid: that.uid,
            }, {
                headers: {
                    token: that.token
                }
            }).then(function(res) {
                //将获取到的数据存入数组
                for (var i = 0; i < 8; i++) {
                    that.notice = res.data;
                }
            })
        },

        // 展示详情
        show_detail: function() {
            var flag = true;
            if (flag === true) {
                this.detail = 'detail_show';
                flag = !flag;
            } else {
                this.detail = 'detail_hidden';
                flag = !flag;
            }
        }
    },
    mounted() {
        this.get_hesuan_check_result();
        this.get_notice();
        this.get_history();
    },
});