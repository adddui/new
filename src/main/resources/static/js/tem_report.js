
var vm = new Vue({
    el: '#app',
    data: {
        /*(id = #{id}, uid = #{uid}, temp = #{temp}, postTime = #{postTime});*/
        id: "",
        uid: localStorage.uid,
        /*
                 #{buildTime},

                 #{temp});*/
        postTime: "",

        token: localStorage.token,

        temp: "",

    },
    methods: {


        sub: function () {
            var that = this;
            axios.post('authority/add_Tem', {
                id: this.id,
                uid: this.id,
                postTime: this.postTime,
                temp: this.temp,

            }, {
                headers: {
                    token: that.token
                }
            }
            ).then(function (res) {
                if (res.data >= 1) {
                    alert("添加成功！");
                    window.location.href = "bs_management.html"
                } else {
                    console("res");
                    alert("添加失败");
                }
            })

        },

        //个人信息
    },
})
