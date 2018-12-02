// pages/cash/cash.js
var api1 = require('../../api1.js');
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {

    price: 0,
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

    var page = this;
    var share_setting = wx.getStorageSync("share_setting");
    page.setData({
      share_setting: share_setting
    });
    app.request({
      url: api1.share.get_price,
      success: function (res) {
        if (res.code == 0) {
          page.setData({
            price: res.data.data.price,
          });
        }
      }
    });
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },
  formSubmit: function (e) {

    var page = this;
    var share_setting = wx.getStorageSync("share_setting");
    wx.showLoading({
      title: "正在提交",
      mask: true,
    });
    var cash = parseFloat(e.detail.value.cash);
    if (share_setting.min_money > cash) {
      wx.showToast({
        title: "提现金额小于" + share_setting.min_money+"元",
        image: "/images/icon-warning.png",
      });
      return;
    }
    if (cash > page.data.price) {
      wx.showToast({
        title: "提现金额大于剩余金额",
        image: "/images/icon-warning.png",
      });
      return;
    }
    app.request({
      url: api1.share.apply,
      method: 'POST',
      data: e.detail.value,
      success: function (res) {
        if (res.code == 0) {
          wx.redirectTo({
            url: '/pages/cash-detail/cash-detail',
          })
        } else {
          wx.showToast({
            title: res.msg,
            image: "/images/icon-warning.png",
          });
        }
      }
    });
  },
})