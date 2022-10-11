var vm = new Vue({
    el: '#login',
    data: {
        account: '',
        //原始密码
        origin_password: '',
        // 取得上边存储的加密过后的密码
        password: '',
        // 验证码
        validateCode: '',
        //取得用户标识
        validateKey: localStorage.validateKey,
        // 这个用处不大，仅是按钮值
        login_status: '登录',

        // 验证码地址
        src: '',
        user_id: '',
        //这里存放请求的目标地址
        url: 'login',
        code_url: 'kaptcha',
    },
    methods: {
        // 加密密码
        encrypt: function () {
            this.password = hex_md5(this.origin_password);
            console.log("encrypt:" + this.password);
        },

        // 刷新验证码
        refresh: function () {
            // 需要先保存当前this，在请求的前后，this会发生变化
            var that = this;
            // 这里直接使用axios的get方法向服务器请求参数即可
            axios.get(this.code_url).then(function (res) {
                // 将html文件中的src修改为请求到的图片的地址
                that.src = res.data.captcha;
                // 将服务器传回的身份标识暂时保存
                that.validateKey = res.headers.validatekey;
                localStorage.setItem("validateKey", that.validateKey);
            })
        },
        // 检查输入合法性
        check: function () {
            if (this.username === '') {
                alert("用户名不能为空！");
                this.refresh();
                return false;
            } else if (this.origin_password === '') {
                alert("密码不能为空！");
                this.refresh();
                return false;
            } else if (this.validateCode === '') {
                alert("验证码不能为空！");
                return false;
            }
            // 加密密码
            this.encrypt();
            return true;
        },
        //登录
        login: function () {
            // 检查输入
            if (!this.check()) return false;
            //登录
            var that = this;
            axios.post(this.url, {
                // 存放请求携带的参数
                password: that.password.trim(),
                validateCode: that.validateCode.trim(),
                validateKey: that.validateKey.trim(),
                account: that.account.trim()
            }).then(function (res) {
                // 请求成功
                if (res.data === "密码错误") {
                    alert("密码错误！请重试！");
                    that.refresh();
                    return false;
                } else if (res.data === "用户名无") {
                    alert("账户不存在！请去注册！");
                    that.refresh();
                    return false;
                } else if (res.data === "验证码错误") {
                    alert("验证码错误！请重新输入！");
                    that.refresh();
                    return false;
                } else {
                    // 后端应该发回前端一个token，前端存储，
                    // 在其他页面请求时，将token放入请求头
                    localStorage.token = res.headers.token;
                    // 将获取到的uid存入缓存捏
                    localStorage.uid = res.headers.uid;
                    // 本窗口跳转
                    window.open('index.html', '_self');
                }
            })
        }
    },
    mounted() {
        this.refresh();
    },
});