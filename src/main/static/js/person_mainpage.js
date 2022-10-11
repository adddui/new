var vm = new Vue({
    el: '#wrapper',
    data: {
        uid: localStorage.uid,
        name: "",
        age: "",
        gender: "",
        password: "",
        token: localStorage.token,
        personalmess: [],
        confirm_password: '',
    },
    methods: {
        // 显示控制

        fix: function () {
            // 输入检查
            if (this.check() == false) return false;
            var that = this;
            // 对密码进行加密
            this.encrypt();
            axios.post('authority/updateUser', {
                uid: this.uid,
                name: this.personalmess.name,
                code: this.personalmess.code,
                password: this.personalmess.password,
                account: this.personalmess.account,
                lastTime: this.personalmess.lastTime,
                idcard: this.personalmess.idcard,
                res: this.personalmess.res,
                gender: this.personalmess.gender,
                address: this.personalmess.address,
                phone: this.personalmess.phone,
                trace: this.personalmess.trace,
            }, {
                headers: {
                    token: that.token
                }
            }).then(function (res) {
                if (res.data >= 1) {
                    alert("修改成功！");
                } else {
                    alert("修改失败！请稍后重试！");
                }
            })
            this.get_mes();
        },

        //个人信息
        get_mes: function () {
            var that = this;
            this.confirm_password = this.personalmess.password;
            axios.post('authority/findUserById', {
                uid: localStorage.uid,
            }, {
                headers: {
                    token: this.token,
                }
            }).then(function (res) {
                // 将取得的数据存入数组
                that.personalmess = res.data;
                that.personalmess = res.data;
            })
        },

        // 检查输入
        check: function () {
            if (this.personalmess.name === '') {
                alert("昵称不能为空！");
                return false;
            }
            if (this.personalmess.password === '') {
                alert("密码不能为空！");
                return false;
            }
            if (this.confirm_password === '') {
                alert("请确认密码！");
                return false;
            } else if (this.personalmess.password != this.confirm_password) {
                alert("两次输入的密码不一致！");
                return false;
            }
            if (this.personalmess.idcard.length != 18) {
                alert("身份证长度必须为 18 位！");
                return false;
            }
            if (this.personalmess.phone.length != 11) {
                alert("电话号码长度必须为 11 位！");
                return false;
            }
            return true;
        },
        // 加密密码
        encrypt: function () {
            var p = hex_md5(this.personalmess.password);
            this.personalmess.password = p;
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
    mounted() {
        this.get_mes();
    },
})
