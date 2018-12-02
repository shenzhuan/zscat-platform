// pages/topic-list/topic-list.js
var api = require('../../api.js');
var api1 = require('../../api1.js');
var app = getApp();
Page({

    /**
     * 页面的初始数据
     */
    data: {},

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        var page = this;
        page.loadTopicList({
            page: 10,
            reload: true,
        });
    },

    loadTopicList: function (args) {
        var page = this;
        if (page.data.is_loading)
            return;
        if (args.loadmore && !page.data.is_more)
            return;
        page.setData({
            is_loading: true,
        });
        app.request({
            url: api1.default.topic_list,
            data: {
                limit: args.page,
            },
            success: function (res) {
                if (res.code == 0) {
                    if (args.reload) {
                        page.setData({
                            list: res.data.rows,
                            page: args.page,
                            is_more: res.data.rows.length > 0
                        });
                    }
                    if (args.loadmore) {
                        page.setData({
                            list: page.data.list.concat(res.data.list),
                            page: args.page,
                            is_more: res.data.rows.length > 0
                        });
                    }
                } else {
                }
            },
            complete: function () {
                page.setData({
                    is_loading: false,
                });
            }
        });
    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function () {
        var page = this;
        page.loadTopicList({
            page: 1,
            reload: true,
        });
    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {
        var page = this;
        page.loadTopicList({
            page: page.data.page + 1,
            loadmore: true,
        });
    },
});