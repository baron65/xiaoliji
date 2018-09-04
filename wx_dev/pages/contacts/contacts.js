// pages/contacts/contacts.js
var common = require('../../utils/common.js')

Page({

  /**
   * 页面的初始数据
   */
  data: {
    searchKeyWord: '',//需要搜索的字符
    friendsHeight: 0,  //中间屏幕高度
    "friends": [{ "name": "维多多", "remark": "[送我]礼金1000元", "date": "20171126", "gender": "0" },
    { "name": "苦久", "remark": "暂无往来", "date": "20180110", "gender": "0" },
    { "name": "小林子", "remark": "[送我]礼金500元", "date": "20170828", "gender": "0" },
    { "name": "Mr Chen", "remark": "[送Ta]礼金400元", "date": "20170816", "gender": "1" },
    { "name": "小卓子", "remark": "[送Ta]礼金800元", "date": "20170423", "gender": "0" },],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    wx.getSystemInfo({

      success: function (res) {
        console.log(res);
        that.setData({
          friendsHeight: res.windowHeight - res.windowWidth / 750 * 133 - res.windowWidth / 750 * 111
        })

      },
    })
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

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  //跳转至往来
  account: function () {
    wx.navigateTo({
      url: '../account/account',
    })
  }
})