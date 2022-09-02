// import axios from "./axios";

refresh()

function refresh() {
    $.ajax({
        url: "kaptcha",
        success: function(data, status, xmlhttp) {
            //data代表的是验证码
            $("#captcha").attr("src", data.captcha);
            //xmlhttp存储了validatekey
            var validateKey = xmlhttp.getResponseHeader("validateKey");
            //后续这个validateKey还要使用，把可以放入页面的缓存
            localStorage.setItem("validateKey", validateKey);
        }
    })
}

$("input[type='button']").on('click', function() {
    var originPassword = $("input[name='password']").val(); //123456
    //使用md5加密把原始密码处理后再传递给后台
    var password = hex_md5(originPassword); //第一次加密，传递给后台的是加密后的密码

    var username = $("input[name='username']").val();

    var validateCode = $("input[name='validateCode']").val();
    //得到用户标识
    var validateKey = localStorage.getItem("validateKey")

    $.ajax({
        url: "login",
        headers: { "validateKey": validateKey },
        data: { "password": password, "username": username, "validateCode": validateCode },
        method: 'POST',
        success: function(data, status, xmlhttp) {
            alert(data);
        }
    })
});


var vm = new Vue({
    el: '#login',
    data: {
        username: '',
        origin_password: '',//原始密码
        // password: hex_md5(this.origin_password),//第一次加密
        validateCode: '',
        validateKey: localStorage.getItem("validateKey"),//取得用户标识
        login_status: '登录',
        user_id: '',
        url: 'login', //这里存放请求的目标地址
    },
    methods: {

        // 检查输入合法性
        check: function() {
            if (this.username === '') {
                alert("用户名不能为空！");
                return false;
            } else if (this.password === '') {
                alert("密码不能为空！");
                return false;
            } else if (this.validateCode === '') {
                alert("验证码不能为空！");
                return false;
            }
            return true;
        },
        //登录
        login: function() {
            // 检查输入
            if (this.check() === true) {
                //登录
                axios.post(this.url, {
                    username: this.username,
                    password: this.origin_password,
                    validateCode:this.validateCode,
                }).then(function(res) {
                    console.log(res)
                    // if (res.data.status == 'true') {
                    //     this.login_status = '登陆成功！';
                    //     // 将返回的数据存入
                    //     sessionStorage.obj = JSON.stringify(res);
                    //     window.location.href = "index.html";
                    // } else if (res.status.status == 1) {
                    //     this.login_status = '用户名或密码错误！';
                    // } else if (res.data.status == 2) {
                    //     this.login_status = '用户不存在！';
                    // }
                })
            }
        }
    },
})