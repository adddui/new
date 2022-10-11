var vm = new Vue({
    el: '#wrapper',
    data: {
        uid: localStorage.uid,
        pod: "",
        destination: "",
        token: localStorage.token,
        startTime: "",
        endTime: "",
        temp: "",
    },
    methods: {
        // 增加返乡上报
        add_return_mess: function () {
            if (!this.check()) return false;
            var that = this;
            axios.post('authority/addReturn_mess', {
                uid: this.uid,
                temp: this.temp,
                pod: this.pod,
                destination: this.destination,
                startTime: this.startTime,
                endTime: this.endTime,
            }, {
                headers: {
                    token: that.token,
                }
            }).then(function (res) {
                if (res.data >= 1) {
                    console.log(res);
                    alert("上报成功！");
                    window.open('bs_management.html', '_self');
                } else {
                    console.log(res);
                    alert("上报失败！请稍后重试...");
                }
            })
        },

        // 检查输入
        check: function () {
            if (this.pod === '') {
                alert("出发地不能为空！");
                return false;
            }
            if (this.destination === '') {
                alert("目的地不能为空！");
                return false;
            }
            if (this.startTime === '') {
                alert("出发时间不能为空！");
                return false;
            }
            if (this.endTime === '') {
                alert("预计到达时间不能为空！");
                return false;
            }
            if (this.endTime <= this.startTime) {
                alert("预计到达时间不能早于出发时间！");
                return false;
            }
            if (this.temp === '') {
                alert("体温不能为空！");
                return false;
            }
            if (this.temp < 35 || this.temp > 43) {
                alert("请输入正确的体温！");
                return false;
            }
            return true;
        },
        // 登出
        logout: function () {
            var con = confirm("确定要退出登录吗？");
            if (!con) return;
            // 清除所有用户数据
            localStorage.clear();// 本窗口跳转
            window.open('login.html', '_self');
        }
    },
})
