
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
        uid: localStorage.uid,
        tids: [],
    },
    methods: {
        // 显示控制

        fix: function () {
            //先检查输入
            var that = this;
            axios.post('authority/update', {
                name: this.name,
                img: this.img,
                age: this.age,
                gender: this.gender,
                password: this.password,
            }, {
                headers: {
                    token: that.token
                }
            }
            ).then(function (res) {
                if (res.data >= 1) {
                    alert("修改成功！");
                    this.show_edit();
                } else {
                    console("res");
                    alert("修改失败！请稍后重试！");
                }
            })
            get_mes();

        },

        //
        get_id: function () {
            var that = this;
            axios.post('authority/findUserById', {
                id: that.uid,
            }, {
                headers: {
                    token: localStorage.getItem("token"),
                }
            }).then(function (res) {
                // 将取得的数据存入数组
                that.personalmess = res.data;
                console.log(res.data);
                that.personalmess = res.data;
            })
        },
    },
})
