var vm = new Vue({
        el: '#app',
        data: {
            // 显示控制
            is_notice_show: true,
            is_edit_show: false,
            //暂存数据
            post_title: '',
            post_content: '',
            uid: '',
            url: 'findAllForum',
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
                this.check();
                //输入无误则发出请求
                axios.post(this.url, {
                    uid: this.uid,
                    title: this.post_title,
                    content: this.post_content,
                }).then(function(res) {
                    if (res.status >= 200 && res.status < 300) {
                        alert("发布成功！");
                        this.show_edit();
                    } else {
                        alert("发布失败！请稍后重试！");
                    }
                })
            },

            //获取帖子
            get_post: function() {
                var that = this;
                axios.post(this.url, {
                    id: 1,
                }, {
                    headers: {
                        'token': localStorage.getItem("token"),
                    }
                }).then(function(res) {
                    // 将取得的数据存入数组
                    that.posts = res.data;
                })
            },

        },

        mounted() {
            this.get_post();
        }
    }

)