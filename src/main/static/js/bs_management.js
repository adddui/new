var vm = new Vue({
    el: '#wrapper',
    data: {
        uid: localStorage.uid,
        token: localStorage.token,
        return_mess: '',
        out_mess: '',
        temp_mess: '',
    },
    methods: {
        // 获取返乡报备
        get_return_mess: function () {
            var that = this;
            axios.post('authority/findReturn_messByUid', {
                uid: this.uid,
            }, {
                headers: {
                    token: that.token,
                }
            }).then(function (res) {
                if (res.data == '') {
                    var doc = document.getElementById("st1");
                    doc.innerText = "暂无记录";
                    doc.setAttribute("colspan", "6");
                    var chi = doc.parentNode.children;
                    for (var i = 1; i < chi.length; i++) {
                        chi[i].setAttribute("style", "display:none;");
                    }
                } else {
                    that.return_mess = res.data;
                }
            })
        },
        // 获取外出报备
        get_out_mess: function () {
            var that = this;
            axios.post('authority/findOut_messByUid', {
                uid: this.uid,
            }, {
                headers: {
                    token: that.token,
                }
            }).then(function (res) {
                if (res.data == '') {
                    var doc = document.getElementById("st2");
                    doc.innerText = "暂无记录";
                    doc.setAttribute("colspan", "6");
                    var chi = doc.parentNode.children;
                    for (var i = 1; i < chi.length; i++) {
                        chi[i].setAttribute("style", "display:none;");
                    }
                } else {
                    that.out_mess = res.data;
                }
            })
        },
        // 获取体温上报
        get_temp_mess: function () {
            var that = this;
            axios.post('authority/findTemperatureByUid', {
                uid: this.uid,
            }, {
                headers: {
                    token: that.token,
                }
            }).then(function (res) {
                if (res.data == '') {
                    var doc = document.getElementById("st3");
                    doc.innerText = "暂无记录";
                    doc.setAttribute("colspan", "2");
                    var chi = doc.parentNode.children;
                    for (var i = 1; i < chi.length; i++) {
                        chi[i].setAttribute("style", "display:none;");
                    }
                } else {
                    that.temp_mess = res.data;
                }
            })
        },
        // 登出
        logout: function () {
            var con = confirm("确定要退出登录吗？");
            if (!con) return;
            // 清除所有用户数据
            localStorage.clear();
            // 本窗口跳转
            window.open('login.html', '_self');
        }
    },
    mounted() {
        this.get_return_mess();
        this.get_out_mess();
        this.get_temp_mess();
    }
})
