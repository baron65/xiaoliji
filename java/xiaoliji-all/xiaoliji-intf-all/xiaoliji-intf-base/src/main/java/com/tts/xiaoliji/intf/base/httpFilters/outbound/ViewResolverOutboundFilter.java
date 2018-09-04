package com.tts.xiaoliji.intf.base.httpFilters.outbound;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.view.ViewResolver;

import cn.openlo.service.HttpOutboundServiceFilter;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

@Component("viewResolverOutboundFilter")
public class ViewResolverOutboundFilter implements HttpOutboundServiceFilter {
	@Autowired
	Map<String, ViewResolver> resolverMap;
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public int getOrder() {
		return 0;
	}

	public void doFilter(HttpServletRequest request, HttpServletResponse response, ServiceRequest serviceRequest,
			ServiceResponse serviceResponse, ServiceContext serviceContext) {
		try {
			String _view_ = processResponse(serviceResponse);
			if (StringUtils.isEmpty(_view_)) {
				_view_ = "json";
			}
			String viewResolverName = _view_ + "Resolver";
			ViewResolver resolver = (ViewResolver) this.resolverMap.get(viewResolverName);
			resolver.render(serviceResponse, request, response);
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
		}
	}

	@SuppressWarnings("unchecked")
	private String processResponse(ServiceResponse resp) {
		String viewType = "json";
		Object model = resp.getModel();
		if (model == null) {
			model = new ConcurrentHashMap<String,Object>(2);
			resp.setModel(model);
		} else {
			Map<String,Object> modelMap = (Map<String,Object>) model;
			viewType = (String) modelMap.remove("_view_");
		}
		return viewType;
	}
}
