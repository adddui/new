
var vm = new Vue({
    el: '#wrapper',
    data: {
        token: localStorage.token,
        uid: localStorage.uid,
        postTime: "",
        temp: "",
    },
    methods: {
        sub: function () {
            if (!this.check()) return false;
            var that = this;
            axios.post('authority/addTemperature', {
                uid: this.uid,
                postTime: this.postTime,
                temp: this.temp,
            }, {
                headers: {
                    token: that.token
                }
            }
            ).then(function (res) {
                if (res.data >= 1) {
                    alert("上报成功！");
                    window.open('bs_management.html', '_self');
                } else {
                    console("res");
                    alert("上报失败！请稍后重试...");
                }
            })
        },

        // 检查输入 
        check: function () {
            if (this.temp === '') {
                alert("请输入体温！");
                return false;
            }
            if (this.temp < 35 || this.temp > 43) {
                alert("请输入正确的体温！");
                return false;
            }
            if (this.postTime === '') {
                alert("请输入时间！");
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
