axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

var vm = new Vue({
    el: '#login',
    data: {
        // 显示控制
        login_show: true,
        retry_show: false,
        account: '',
        // 原密码
        origin_password: '',
        // 加密后的密码
        password: '',
        validate_code: '',
        register_status: '注册',
        returnLogin: '注册成功! 点击返回登录',
        comfirm_password: '',
        nick_name: '',
        url: 'register', //这里放请求的目标地址
    },
    methods: {
        // 加密密码
        encrypt: function () {
            this.password = hex_md5(this.origin_password);
            console.log("encrypt:" + this.password);
        },

        // 检查输入合法性
        check: function () {
            if (this.account.trim() === '') {
                alert("账户不能为空！");
                return false;
            } else if (this.origin_password.trim() === '') {
                console.log(this.origin_password);
                console.log(this.origin_password.trim());
                alert("密码不能为空！");
                return false;
            } else if (this.comfirm_password === '') {
                alert("请确认密码！");
                return false;
            } else if (this.origin_password.trim() != this.comfirm_password.trim()) {
                alert("两次输入的密码不一致!");
                return false;
            } else if (this.nick_name.trim() === '') {
                alert("昵称不能为空！");
                return false;
            }
            // 加密密码
            this.encrypt();
            return true;
        },
        //注册
        register: function () {
            // 检查输入
            if (!this.check()) return false;
            //注册
            var that = this;
            axios.post(this.url, {
                // 给接口的参数
                // 昵称
                name: that.nick_name.trim(),
                // 密码
                password: that.password.trim(),
                // 账户
                account: that.account.trim(),
            }).then(function (res) {
                if (res.data === "account已存在") {
                    alert("账户已存在，请重试！");
                    return false;
                } else if (res.data === "注册成功") {
                    that.login_show = !that.login_show;
                }
            })
        }
    },
})