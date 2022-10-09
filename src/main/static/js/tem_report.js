
var vm = new Vue({
    el: '#app',
    data: {
        token: localStorage.token,
        uid: localStorage.uid,
        postTime: "",
        temp: "",
    },
    methods: {
        sub: function () {
            if (this.check() === false) return false;
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
                    alert("上报失败");
                }
            })
        },

        // 检查输入 
        check: function () {
            if (this.temp === '') {
                alert("请输入体温！");
                return false;
            }
            if (this.postTime === '') {
                alert("请输入时间！");
                return false;
            }
            return true;
        }
    },
})
