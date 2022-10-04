
var vm = new Vue({
    el: '#app',
    data: {
        /*et name= #{name},
       code= #{code},
       password= #{password},
       salt= #{salt},
       account= #{account},
       lastTime= #{lastTime},
       idcard= #{idcard},
       res= #{res},
       gender= #{gender},
       img=#{img},
       address= #{address},
       phone=#{phone},
       trace=#{trace}*/
        id: "",
        uid: localStorage.uid,
        /*
                 #{buildTime},
                 #{uid},
                 #{pod},
                 #{destination},
                 #{startTime},
                 #{endTime},
                 #{temp});*/
        buildtime: "",
        pod: "",
        destination: "",
        token: localStorage.token,
        startTime: "",
        endTime: "",
        temp: "",

    },
    methods: {


        sub: function () {
            var that = this;
            axios.post('authority/add_Out_mess', {
                id: this.id,
                uid: localStorage.uid,
                buildtime: this.buildtime,
                pod: this.pod,
                startTime: this.StartTime,
                endTime: this.endTime,
                temp: this.temp,
                destination: this.destination,


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
