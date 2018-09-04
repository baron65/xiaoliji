// pages/userInfo/userInfo.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    array: ['男', '女'],
    "tags": [{ "tag": "同学", "checked": true }, { "tag": "同事", "checked": true }, { "tag": "亲人", "checked": true }, { "tag": "同事", "checked": true }, { "tag": "亲人", "checked": true }, { "tag": "同事", "checked": true }, { "tag": "亲人", "checked": true }, { "tag": "同事", "checked": true }, { "tag": "亲人", "checked": true }, { "tag": "同事", "checked": true }, { "tag": "亲人", "checked": true }, { "tag": "同事", "checked": true }, { "tag": "亲人", "checked": true }, { "tag": "同事", "checked": true }, { "tag": "亲人", "checked": true }, { "tag": "同事", "checked": true }, { "tag": "亲人", "checked": true }, { "tag": "同事", "checked": true }, { "tag": "亲人", "checked": true }],
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
  bindPickerChange: function (e) {
    this.setData({
      index: e.detail.value
    })
  },
  tag: function (e) {
    var that = this
    wx.navigateTo({
      url: '../tags/tags',
    })
  },
  //跳转至联系人
  returnContacts: function () {
    wx.navigateBack();
  }
})