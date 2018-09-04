package com.tts.xiaoliji.intf.base.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.openlo.service.ServiceResponse;

public abstract interface ViewResolver {
	public abstract void render(ServiceResponse paramServiceResponse, HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse) throws Exception;
}
