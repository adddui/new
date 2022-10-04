var vm = new Vue({
    el: '#app',
    data: {
        // 显示控制
        is_notice_show: true,
        is_edit_show: false,
        is_detail_show: false,
        no_post: false,
        //暂存数据
        uid: localStorage.uid,
        token: localStorage.token,
        builder_name: '',
        post_title: '',
        builder_id: [],
        builder: '',
        //帖子
        posts: [],
        post_title_detail: '',
        post_user_name_detail: '',
        post_content: '',
        post_time_detail: '',

    },
    methods: {
        // 显示控制
        show_edit: function () {
            if (this.is_edit_show == true) {
                this.is_edit_show = false;
                this.is_detail_show = false;
                this.is_notice_show = true;
            } else if (this.is_edit_show == false) {
                this.post_content = '';
                this.is_edit_show = true;
                this.is_detail_show = false;
                this.is_notice_show = false;
            }
        },
        // 展示帖子详情
        show_detail: function (index) {
            //显示控制
            if (this.is_detail_show == true) {
                this.is_edit_show = false;
                this.is_detail_show = false;
                this.is_notice_show = true;
            } else if (this.is_detail_show == false) {
                var b_id = this.posts[index].builder;
                this.get_post_builder(b_id);
                this.post_title_detail = this.posts[index].title;
                this.post_content = this.posts[index].message;
                this.post_time_detail = this.posts[index].sendTime;
                this.is_edit_show = false;
                this.is_detail_show = true;
                this.is_notice_show = false;
            }
        },

        // 检查输入
        check: function () {
            if (this.post_title === '') {
                alert("标题不能为空！");
                return false;
            } else if (this.post_content === '') {
                alert("内容不能为空！");
                return false;
            }
            else {
                return true;
            }
        },

        //发布
        post: function () {
            //先检查输入
            var that = this;
            if (this.check()) {
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
                ).then(function (res) {
                    if (res.data >= 1) {
                        alert("发布成功！");
                        location.reload();
                    } else {
                        console("res");
                        alert("发布失败！请稍后重试！");
                    }

                })
            }
        },

        //获取帖子
        get_post: function () {
            var that = this;
            axios.post('authority/findAllForum', {
                id: that.uid,
            }, {
                headers: {
                    token: localStorage.getItem("token"),
                }
            }).then(function (res) {
                // 将取得的数据存入数组
                if (res.data.length == 0) {
                    that.no_post = true;
                } else {
                    that.posts = res.data;
                    console.log(that.builder_id);
                    console.log(res.data);
                    that.posts = res.data;
                }
            })
        },

        // 获取帖子发布者
        get_post_builder: function (builder_id) {
            var that = this;
            axios.post('authority/findUserById', {
                uid: builder_id,
            }, {
                headers: {
                    token: that.token,
                }
            }).then(function (res) {
                console.log("name: " + res.data.name);
                that.builder = res.data.name;
            })
        },


    },

    mounted() {
        this.get_post();
    }
}

)