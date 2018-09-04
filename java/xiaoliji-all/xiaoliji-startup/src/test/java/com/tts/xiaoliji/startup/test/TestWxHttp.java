package com.tts.xiaoliji.startup.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.tts.xiaoliji.common.dto.rap.gwwx.Jscode2sessionRequest;

import cn.openlo.gear.test.GearContextConfiguration;
import cn.openlo.gear.test.GearTestBase;
import cn.openlo.service.LOSClient;
import cn.openlo.service.LOServiceClient;
import cn.openlo.service.ServiceResponse;

@GearContextConfiguration(boxName = "S4901", boxHome = "${user.dir}/src/test/resources/box01/", gearName = "xiaoliji-startup", gearStartTimeout = 200000)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestWxHttp extends GearTestBase {

	@LOSClient(calleename = "gw-wx.jscode2session")
	private LOServiceClient jscode2session;

	@Test
	public void iz10_ztAddProduct() throws Throwable {
		try {
			Jscode2sessionRequest request = new Jscode2sessionRequest();
			request.setAppid("wx60f3bfdbf80038ab");
			request.setSecret("5d40c035ae1e47f587b131cdad06e1c0");

			ServiceResponse response = jscode2session.sendRequest(request);
			System.out.println("jscode2session■■■■■■■■■■■■■■■■■■");
			System.out.println(response.getResponseCode() + ":" + response.getResponseMsg());
			System.out.println(response.getModel());
			Assert.assertEquals("000000", response.getResponseCode());
			System.out.println("■■■■■■■■■■■■■■■■■■");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}