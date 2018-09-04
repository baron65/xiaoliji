//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    var that = this;
    //检查登录态
    wx.checkSession({
      success: function () {
        console.log('checkSession.success')
        //session 未过期，并且在本生命周期一直有效
        that.wxLogin() //重新登录
      },
      fail: function () {
        console.log('checkSession.fail')
        //登录态过期
        wxLogin() //重新登录
      }
    })
  },

  // 微信登录
  wxLogin: function () {
    var that = this;
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        var code = res.code;
        if (code) {
          that.xljLogin(code);
        } else {
          console.log('获取用户登录态失败：' + res.errMsg);
        }
      }
    })
  },

  // 后台登录
  xljLogin: function (jsCode) {

    // 获取用户信息
    wx.getSetting({
      success: res => {
        console.log('wx.getSetting.success')
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              console.log('wx.getUserInfo.success.res.userInfo=' + JSON.stringify(res.userInfo))
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
              var custInfoxxx = {
                avatarUrl: res.userInfo.avatarUrl,
                city: res.userInfo.city,
                country: res.userInfo.country
              }


              // 发送 res.code 到后台换取 openId, sessionKey, unionId
              wx.request({
                url: 'https://www.xiaoliji.com/service/xiaoliji-intf-cust.wxLogin',
                data: {
                  jsCode: jsCode,
                  custInfo: custInfoxxx
                },
                method: 'POST',
                success: function (res) {
                  console.log(res)
                  if (res.Status == 'SUCCESS' && res.BizData.Status == 'SUCCESS') {
                    console.log('SUCCESS')
                  }
                }
              })
            }
          })
        }
      }
    })

  },
  globalData: {
    userInfo: null
  }
})