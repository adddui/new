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
            if (this.check() === false) return false;
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
                    alert("上报失败！");
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
            if (this.temp === '') {
                alert("体温不能为空！");
                return false;
            }
            return true;
        }


    },
}

)
