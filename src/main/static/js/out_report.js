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
        // 增加外出上报
        add_out_mess: function () {
            if (!this.check()) return false;
            var that = this;
            axios.post('authority/addOut_mess', {
                uid: this.uid.trim(),
                temp: this.temp.trim(),
                pod: this.pod.trim(),
                destination: this.destination.trim(),
                startTime: this.startTime.trim(),
                endTime: this.endTime.trim(),
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
                    alert("上报失败！");
                }
            })
        },

        // 检查输入
        check: function () {
            if (this.pod.trim() === '') {
                alert("出发地不能为空！");
                return false;
            }
            if (this.destination.trim() === '') {
                alert("目的地不能为空！");
                return false;
            }
            if (this.startTime.trim() === '') {
                alert("出发时间不能为空！");
                return false;
            }
            if (this.endTime.trim() === '') {
                alert("预计到达时间不能为空！");
                return false;
            }
            if (this.endTime.trim() <= this.startTime.trim()) {
                alert("预计到达时间不能早于出发时间！");
                return false;
            }
            if (this.temp.trim() === '') {
                alert("体温不能为空！");
                return false;
            }
            if (this.temp.trim() < 35 || this.temp.trim() > 42) {
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
});
