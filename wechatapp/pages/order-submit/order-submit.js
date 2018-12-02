// order-submit.js
var api1 = require('../../api1.js');
var app = getApp();
Page({

    /**
     * 页面的初始数据
     */
    data: {
        total_price: 0,
        address: null,
        express_price: 0.00,
        content: '',
        offline: 0,
        express_price_1: 0.00,
        name: "",
        mobile: ""
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        var page = this;
        page.setData({
            options: options,
            store: wx.getStorageSync("store")
        });
    },
    bindkeyinput: function (e) {
        this.setData({
            content: e.detail.value
        });
    },
    KeyName: function (e) {
        this.setData({
            name: e.detail.value
        });
    },
    KeyMobile: function (e) {
        this.setData({
            mobile: e.detail.value
        });
    },
    getOffline: function (e) {
        var express = this.data.express_price;
        var express_1 = this.data.express_price_1;
        var offline = e.target.dataset.index;
        if (offline == 1) {
            this.setData({
                offline: offline,
                express_price: 0,
                express_price_1: express
            });
        } else {
            this.setData({
                offline: offline,
                express_price: express_1
            });
        }
    },

    orderSubmit: function () {
		var access_token = wx.getStorageSync("access_token");
		
        var page = this;
        var offline = page.data.offline;
        var data = {};
		data.userid=access_token;
		data.express_price=page.data.express_price;
        if (offline == 0) {
            if (!page.data.address || !page.data.address.id) {
                wx.showToast({
                    title: "请选择收货地址",
                    image: "/images/icon-warning.png",
                });
                return;
            }
            data.addressid = page.data.address.id;
        } else {
            data.address_name = page.data.name;
            data.address_mobile = page.data.mobile;
            if (page.data.shop.id)
                data.shop_id = page.data.shop.id;
        }
        data.offline = offline;
        if (page.data.cart_id_list) {
            data.cart_id_list = page.data.cart_id_list;
        }
        if (page.data.cartid) {
            data.cartid = page.data.cartid;
        }
        if (page.data.picker_coupon) {
            data.couponid = page.data.picker_coupon.id;
        }
        if (page.data.content) {
            data.content = page.data.content
        }
        wx.showLoading({
            title: "正在提交",
            mask: true,
        });
			
			console.log('orderData:'+JSON.stringify(data));
			
        //提交订单
        app.request({
            url: api1.order.submit,
            method: "post",
            data: data,
            success: function (res) {
                if (res.code == 0) {
                    setTimeout(function () {
                        wx.hideLoading();
                    }, 1000);
                    setTimeout(function () {
                        page.setData({
                            options: {},
                        });
                    }, 1);
                    var order_id = res.data.id;

                    //获取支付数据
                    app.request({
                        url: api1.order.pay_data,
                        data: {
                            orderid: order_id,
                            pay_type: 'WECHAT_PAY',
                        },
                        success: function (res) {
                            if (res.code == 0) {
                                //发起支付
                                wx.requestPayment({
                                    timeStamp: res.data.timeStamp,
                                    nonceStr: res.data.nonceStr,
                                    package: res.data.package,
                                    signType: res.data.signType,
                                    paySign: res.data.paySign,
                                    success: function (e) {
                                        wx.redirectTo({
                                            url: "/pages/order/order?status=1",
                                        });
                                    },
                                    fail: function (e) {
                                    },
                                    complete: function (e) {
                                        if (e.errMsg == "requestPayment:fail" || e.errMsg == "requestPayment:fail cancel") {//支付失败转到待支付订单列表
                                            wx.showModal({
                                                title: "提示",
                                                content: "订单尚未支付",
                                                showCancel: false,
                                                confirmText: "确认",
                                                success: function (res) {
                                                    if (res.confirm) {
                                                        wx.redirectTo({
                                                            url: "/pages/order/order?status=9",
                                                        });
                                                    }
                                                }
                                            });
                                            return;
                                        }
                                        if (e.errMsg == "requestPayment:ok") {
                                            return;
                                        }
                                        wx.redirectTo({
                                            url: "/pages/order/order?status=1",
                                        });
                                    },
                                });
                                return;
                            }
                            if (res.code == 1) {
                                wx.showToast({
                                    title: res.msg,
                                    image: "/images/icon-warning.png",
                                });
                                return;
                            }
                        }
                    });
                }
                if (res.code == 1) {
                    wx.hideLoading();
                    wx.showToast({
                        title: res.msg,
                        image: "/images/icon-warning.png",
                    });
                    return;
                }
            }
        });
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
        var address = wx.getStorageSync("picker_address");
        if (address) {
            page.setData({
                address: address,
                name: address.name,
                mobile: address.mobile
            });
            wx.removeStorageSync("picker_address");
        }
        page.getOrderData(page.data.options);
    },

    getOrderData: function (options) {
		var access_token = wx.getStorageSync("access_token");
        var page = this;
        var address_id = "";
        if (page.data.address && page.data.address.id)
            address_id = page.data.address.id;
        if (options.cart_id_list) {
            var cart_id_list = JSON.parse(options.cart_id_list);
            wx.showLoading({
                title: "正在加载",
                mask: true,
            });
            app.request({
                url: api1.order.submit_preview,
                data: {
					userid:access_token,
                    cart_id_list: options.cart_id_list,
                    addressid: address_id,
                },
                success: function (res) {
                    wx.hideLoading();
                    if (res.code == 0) {
                        page.setData({
                            total_price: parseFloat(res.data.total_price),
                            goods_list: res.data.goodsList,
                            cart_id_list: res.data.cart_id_list,
                            address: res.data.address,
                            express_price: parseFloat(res.data.express_price),
                            coupon_list: res.data.couponList,
                            shop_list: res.data.shop_list,
                            shop: res.data.shop_list[0] || {},
                            name: res.data.address ? res.data.address.name : '',
                            mobile: res.data.address ? res.data.address.mobile : '',
                            send_type: res.data.send_type,
                        });
                        if (res.data.send_type == 1) {//仅快递
                            page.setData({
                                offline: 0,
                            });
                        }
                        if (res.data.send_type == 2) {//仅自提
                            page.setData({
                                offline: 1,
                            });
                        }
                    }
                    if (res.code == 1) {
                        wx.showModal({
                            title: "提示",
                            content: res.msg,
                            showCancel: false,
                            confirmText: "返回",
                            success: function (res) {
                                if (res.confirm) {
                                    wx.navigateBack({
                                        delta: 1,
                                    });
                                }
                            }
                        });
                    }
                }
            });
        }
        if (options.goods_info) {
            wx.showLoading({
                title: "正在加载",
                mask: true,
            });
            app.request({
                url: api1.order.submit_preview,
                data: {
					userid:access_token,
                    goods_info: options.goods_info,
                    addressid: address_id,
                },
                success: function (res) {
                    wx.hideLoading();
                    if (res.code == 0) {
                        page.setData({
                            total_price: res.data.total_price,
                            goods_list: res.data.goodsList,
                            cartid: res.data.cartid,
                            address: res.data.address,
                            express_price: parseFloat(res.data.express_price),
                            coupon_list: res.data.couponList,
                            shop_list: res.data.shop_list,
                            shop: res.data.shop_list[0] || {},
                            name: res.data.address ? res.data.address.name : '',
                            mobile: res.data.address ? res.data.address.mobile : '',
                            send_type: res.data.send_type,
                        });
                        if (res.data.send_type == 1) {//仅快递
                            page.setData({
                                offline: 0,
                            });
                        }
                        if (res.data.send_type == 2) {//仅自提
                            page.setData({
                                offline: 1,
                            });
                        }
                    }
                    if (res.code == 1) {
                        wx.showModal({
                            title: "提示",
                            content: res.msg,
                            showCancel: false,
                            confirmText: "返回",
                            success: function (res) {
                                if (res.confirm) {
                                    wx.navigateBack({
                                        delta: 1,
                                    });
                                }
                            }
                        });
                    }
                }
            });
        }
    },

    copyText: function (e) {
        var text = e.currentTarget.dataset.text;
        if (!text)
            return;
        wx.setClipboardData({
            data: text,
            success: function () {
                wx.showToast({
                    title: "已复制内容",
                });
            },
            fail: function () {
                wx.showToast({
                    title: "复制失败",
                    image: "/images/icon-warning.png",
                });
            },
        });
    },

    showCouponPicker: function () {
        var page = this;
        if (page.data.coupon_list && page.data.coupon_list.length > 0) {
            page.setData({
                show_coupon_picker: true,
            });
        }
    },

    pickCoupon: function (e) {
		
        var page = this;
        var index = e.currentTarget.dataset.index;

        if (index == '-1' || index == -1) {
            page.setData({
                picker_coupon: false,
                show_coupon_picker: false,
            });
        } else {
            page.setData({
                picker_coupon: page.data.coupon_list[index],
                show_coupon_picker: false,
                new_total_price: parseFloat((page.data.total_price - page.data.coupon_list[index].sub_price).toFixed(2)),
            });
        }
		
    },

    numSub: function (num1, num2, length) {
        return 100;
    },
    showShop: function (e) {
        var page = this;
        if (page.data.shop_list && page.data.shop_list.length > 1) {
            page.setData({
                show_shop: true,
            });
        }
    },
    pickShop: function (e) {
        var page = this;
        var index = e.currentTarget.dataset.index;
        if (index == '-1' || index == -1) {
            page.setData({
                shop: false,
                show_shop: false,
            });
        } else {
            page.setData({
                shop: page.data.shop_list[index],
                show_shop: false,
            });
        }
    }

});