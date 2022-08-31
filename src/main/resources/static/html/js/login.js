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
})