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
            url: '',
            //帖子
            posts: [
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
                { title: '今日新增病例', author: '社区官方', time: '2022-8-31', },
            ],
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
                }).then(res => function() {
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
                axios.post(this.url).then(res => function() {
                    // 将取得的数据存入数组
                    this.posts.push(res.data.result);
                })
            },

        },
    }

)