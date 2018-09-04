var app = getApp();
Page({
  data: {
    userInfo: {},
    showModal: false,
    accHeight: 300,
    expenditures: {
      "totalAmountIn": "80000",
      "totalAmountOut": "1100",
      "list": [
        { "type": "out", "amount": "100", "date": "20170101", "remark": "元旦1" },
        { "type": "out", "amount": "100", "date": "20170101", "remark": "元旦2" },
        { "type": "out", "amount": "100", "date": "20170101", "remark": "元旦3" },
        { "type": "out", "amount": "100", "date": "20170101", "remark": "元旦4" },
        { "type": "out", "amount": "100", "date": "20170101", "remark": "元旦5" },
        { "type": "in", "amount": "40000", "date": "20170225", "remark": "拜年" },
        { "type": "out", "amount": "200", "date": "20170416", "remark": "看望" },
        { "type": "in", "amount": "20000", "date": "20170501", "remark": "生日" },
        { "type": "in", "amount": "30000", "date": "20170816", "remark": "来医院探望" },
        { "type": "out", "amount": "500", "date": "20171228", "remark": "给小孩的压岁钱" },
        { "type": "out", "amount": "300", "date": "20180101", "remark": "顺路拜访" }
      ]
    }
  },
  onLoad: function () {
    this.setScrollHeight();

  },

  //设置滚动框的高度
  setScrollHeight: function () {
    const that = this;
    wx.getSystemInfo({
      success: function (res) {
        console.log(res)
        that.setData({
          accHeight: res.windowHeight - res.windowWidth / 1080 * 330 - res.windowWidth / 1080 * 190
        })
      },
    })
  },

  clickMe: function () {
    this.setData({
      showModal: true
    })
  },

  hideModal: function () {
    this.setData({
      showModal: false
    });
  },

  /**
   * 弹出框蒙层截断touchmove事件
   */
  preventTouchMove: function (e) {
    console.log(e)
  },

  onCancel: function () {
    this.hideModal();
  },

  onConfirm: function () {
    this.hideModal();
  },
})