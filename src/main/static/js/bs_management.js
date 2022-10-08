var vm = new Vue({
    el: '#wrapper',
    data: {
        uid: localStorage.uid,
        token: localStorage.token,
        return_mess: [],
        out_mess: [],
        temp_mess: [],
    },
    methods: {

        // 获取返乡报备
        get_return_mess: function () {
            var that = this;
            console.log(this.token);
            axios.post('authority/findReturn_messByUid', {
                uid: this.uid,
            }, {
                headers: {
                    token: that.token,
                }
            }).then(function (res) {
                console.log(res);
                if (res == null) {

                } else {
                    that.return_mess = res.data;
                }
            })
        },
        // 获取外出报备
        get_out_mess: function () {
            var that = this;
            console.log(this.token);
            axios.post('authority/findOut_messByUid', {
                uid: this.uid,
            }, {
                headers: {
                    token: that.token,
                }
            }).then(function (res) {
                console.log(res);
                if (res == null) {

                } else {
                    that.out_mess = res.data;
                }
            })
        },
        // 获取体温上报
        get_temp_mess: function () {
            var that = this;
            console.log(this.token);
            axios.post('authority/findTemperatureByUid', {
                uid: this.uid,
            }, {
                headers: {
                    token: that.token,
                }
            }).then(function (res) {
                console.log(res);
                if (res == null) {

                } else {
                    that.temp_mess = res.data;
                }
            })
        }
    },
    mounted() {
        this.get_return_mess();
        this.get_out_mess();
        this.get_temp_mess();
    }
})
