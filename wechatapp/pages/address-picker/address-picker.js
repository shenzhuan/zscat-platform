var api1 = require('../../api1.js');
var app = getApp();
Page({

    /**
     * 页面的初始数据
     */
    data: {
        address_list: null,
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {
		 var access_token = wx.getStorageSync("access_token");
        var page = this;
        wx.showNavigationBarLoading();
        app.request({
            url: api1.user.address_list,
				 data:{
				  userid:access_token,
				  limit:15
				},
            success: function (res) {
                wx.hideNavigationBarLoading();
                if (res.code == 0) {
                    page.setData({
                        address_list: res.data.rows,
                    });
                }
            }
        });
    },

    pickAddress: function (e) {
        var page = this;
        var index = e.currentTarget.dataset.index;
        var address = page.data.address_list[index];
        wx.setStorageSync("picker_address", address);
        wx.navigateBack();
    },

    getWechatAddress: function (e) {
        var page = this;
        wx.chooseAddress({
            success: function (e) {
                if (e.errMsg != 'chooseAddress:ok')
                    return;
                wx.showLoading();
				console.log('e.nationalCode'+e.nationalCode);
				 var access_token = wx.getStorageSync("access_token");
                app.request({
                    url: api1.user.add_wechat_address,
                    method: "post",
                    data: {
						userid:access_token,
                        national_code: e.nationalCode,
                        name: e.userName,
                        mobile: e.telNumber,
                        detail: e.detailInfo,
                    },
                    success: function (res) {
                        if (res.code == 1) {
                            wx.showModal({
                                title: '提示',
                                content: res.msg,
                                showCancel: false,
                            });
                            return;
                        }
                        if (res.code == 0) {
                            wx.setStorageSync("picker_address", res.data);
                            wx.navigateBack();
                        }
                    },
                    complete: function () {
                        wx.hideLoading();
                    }
                });
            }
        });
    },
});