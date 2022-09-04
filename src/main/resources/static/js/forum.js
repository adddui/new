var vm = new Vue({
        el: '#app',
        data: {
            // 显示控制
            is_notice_show: true,
            is_edit_show: false,
            //暂存数据
            post_title: '',
            post_content: '',
            uid: localStorage.uid,
            token: localStorage.token,
            builder_id: [],
            builder: [],
            //帖子
            posts: [],
        },
        methods: {
            // 显示控制
            show_edit: function() {
                this.is_edit_show = !this.is_edit_show;
                this.is_notice_show = !this.is_notice_show;
            },

            // 检查输入
            check: function() {
                if (this.post_title === '') {
                    alert("标题不能为空！");
                    return false;
                } else if (this.post_content === '') {
                    alert("内容不能为空！");
                    return false;
                }
                return true;
            },

            //发布
            post: function() {
                //先检查输入
                var that = this;
                this.check();
                //输入无误则发出请求
                axios.post('authority/addForum', {
                        builder: this.uid,
                        title: this.post_title,
                        message: this.post_content,
                    }, {
                        headers: {
                            token: that.token
                        }
                    }

                ).then(function(res) {
                    if (res.data >= 1) {
                        alert("发布成功！");
                        this.show_edit();
                    } else {
                        console("res");
                        alert("发布失败！请稍后重试！");
                    }
                })
            },

            //获取帖子
            get_post: function() {
                var that = this;
                axios.post('authority/findAllForum', {
                    id: that.uid,
                }, {
                    headers: {
                        token: localStorage.getItem("token"),
                    }
                }).then(function(res) {
                    // 将取得的数据存入数组
                    that.posts = res.data;
                    console.log(that.builder_id);
                    console.log(res.data);
                    that.posts = res.data;
                })
            },

            // 获取帖子发布者
            // get_post_builder: function(builder_id) {
            //     var that = this;
            //     axios.post('authority/findUserById', {
            //         uid: builder_id,
            //     }, {
            //         headers: {
            //             token: that.token,
            //         }
            //     }).then(function(res) {
            //         console.log("name: " + res.data.name)
            //         that.builder = res.data.name;
            //     })
            // }
        },

        mounted() {
            this.get_post();
        }
    }

)