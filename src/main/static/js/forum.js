var vm = new Vue({
    el: '#app',
    data: {
        // 显示控制
        is_notice_show: true,
        is_edit_show: false,
        is_detail_show: false,
        no_post: false,
        edit_mine: false,
        is_my_notice_show: false,
        edit_mine_post: false,
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
        index: '',
        post_value: '发布',
        // 修改帖子
        message: '',
        title: '',
    },
    methods: {
        // 显示控制
        show_edit: function (str) {
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
            // this.get_post();

            if (this.is_detail_show === true) {
                this.is_edit_show = false;
                this.is_detail_show = false;
                this.is_my_notice_show = false;
                this.is_notice_show = true;
            } else if (this.is_detail_show === false) {
                this.get_post_builder(this.posts[index].builder);
                this.post_title_detail = this.posts[index].title;
                this.post_content = this.posts[index].message;
                this.post_time_detail = this.posts[index].sendTime;
                this.is_edit_show = false;
                this.is_my_notice_show = false;
                this.is_detail_show = true;
                this.is_notice_show = false;

                this.title = this.post_title_detail;
                this.message = this.post_content;

                // 如果是自己的帖子则显示编辑按钮
                if (this.posts[index].builder == this.uid) {
                    this.edit_mine = true;
                    this.index = this.posts[index].id;
                } else {
                    this.edit_mine = false;
                }
            }
        },

        show_my_post: function () {
            if (this.is_my_notice_show == false) {
                this.is_notice_show = false;
                this.is_edit_show = false;
                this.is_detail_show = false;
                this.no_post = false;
                this.edit_mine = false;
                this.is_my_notice_show = true;
            }
            else {
                this.is_notice_show = true;
                this.is_edit_show = false;
                this.is_detail_show = false;
                this.no_post = false;
                this.edit_mine = false;
                this.is_my_notice_show = false;
            }
        },

        show_my_post_edit: function () {
            if (this.edit_mine_post == false) {
                this.edit_mine_post = true;
                this.is_notice_show = false;
                this.is_edit_show = false;
                this.is_detail_show = false;
                this.no_post = false;
                this.edit_mine = false;
                this.is_my_notice_show = false;
            }
            else {
                this.is_notice_show = true;
                this.is_edit_show = false;
                this.is_detail_show = false;
                this.no_post = false;
                this.edit_mine = false;
                this.is_my_notice_show = false;
                this.edit_mine_post = false;
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

        // 检查输入
        check_edit: function () {
            if (this.title === '') {
                alert("标题不能为空！");
                return false;
            } else if (this.message === '') {
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
                if (res.data.length === 0) {
                    that.no_post = true;
                } else {
                    that.posts = res.data;
                    console.log(res.data);
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
                that.builder_name = res.data.name;
            })
        },


        // 删除自己的帖子
        delete_post: function () {
            console.log("删除自己的帖子" + this.index);
            var con = confirm("确定要删除吗？")
            if (con === false) return;
            var that = this;
            axios.post('authority/deleteForum', {
                id: this.index
            }, {
                headers: {
                    token: that.token,
                }
            }).then(function (res) {
                console.log("delete:" + res);
                if (res.data === 0) {
                    alert("删除失败！");
                } else {
                    alert("删除成功！");
                    location.reload();
                }
            })
        },

        // 编辑自己的帖子
        edit_post: function () {
            if (this.check_edit() === false) return false;
            var that = this;
            axios.post('authority/updateForumById', {
                id: this.index,
                builder: this.uid,
                message: this.message,
                title: this.title,
            }, {
                headers: {
                    token: that.token,
                }
            }).then(function (res) {
                if (res.data >= 1) {
                    console.log(res.data);
                    alert("修改成功！");
                    location.reload();
                } else {
                    alert("修改失败！");
                }
            })
        }
    },

    mounted() {
        this.get_post();
    }
}

)