
var vm = new Vue({
        el: '#app',
        data: {
            /*(id = #{id}, uid = #{uid}, temp = #{temp}, postTime = #{postTime});*/

            token: localStorage.token,
            uid: localStorage.uid,
            /*
                     #{buildTime},

                     #{temp});*/
           postTime:"",

            temp:"",

        },
        methods: {


            sub: function () {
                var that = this;
                axios.post('authority/add_Tem', {

                     uid:this.uid,
                     postTime:this.postTime,
                     temp:this.temp,

                    }, {
                        headers: {
                            token: that.token
                        }
                    }
                ).then(function (res) {
                    if (res.data >= 1) {
                        alert("添加成功！");
                        window.location.href="bs_management.html"
                    } else {
                        console("res");
                        alert("添加失败");
                    }
                })

            },

            //个人信息



        },


    }

)
