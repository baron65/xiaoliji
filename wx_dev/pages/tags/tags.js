// pages/tags/tags.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    "tags": [{ "tag": "同学", "checked": false }, { "tag": "同事", "checked": false }, { "tag": "亲人", "checked": false }],
    "choose": [],

    tagWidth: 80,
    valueClear: ''
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
  //为联系人添加标签

  //增加标签
  addTag: function (e) {
    if (e.detail.value == '' || e.detail.value.length == 0) {
      return;
    }
    var that = this
    function tag(tag, checked) {
      this.tag = tag;
      this.checked = checked
    }
    console.log(e.detail.value)
    var tag = new tag(e.detail.value, true)
    that.data.tags.push(tag)
    that.setData({
      tags: that.data.tags,
      valueClear: ''
    })
  },

  //设置标签被选中
  checked: function (e) {
    var that = this
    var tag = this.data.tags[e.target.id]
    var tagString = "tags[" + e.target.id + "].checked";
    if (!tag.checked)
      that.setData({
        [tagString]: true
      })

    else
      that.setData({
        [tagString]: false
      })
  },
  //删除标签
  deleted: function (e) {

    var that = this
    var id = e.currentTarget.dataset.id;
    var tagString = "tags[" + id + "].checked";
    that.setData({
      [tagString]: false
    })
  },
  //添加标签input宽度自适应
  widthChange: function (e) {
    var that = this;
    var length = e.detail.value.length;
    var tagMsg = '';
    var msg = e.detail.value;
    that.setData({
      msg: e.detail.value
    })
    //创建节点选择器
    var query = wx.createSelectorQuery();
    query.select('#msg').boundingClientRect()
    query.exec(function (res) {
      //res就是 所有标签为msg的元素的信息 的数组
      //取高度
      console.log('aaaaaa' + res[0].width);
      var width = res[0].width + 20
      if (width < 80) {
        width = 80
      } else if (width > 250) {
        width = 250
      }
      if (length > 18)
        tagMsg = "标签最多支持18个字，已经超过" + (length - 18) + "个字"
      else
        tagMsg = ''
      that.setData({
        tagWidth: width,
        tagMsg: tagMsg,
      })
    })

  }
})
