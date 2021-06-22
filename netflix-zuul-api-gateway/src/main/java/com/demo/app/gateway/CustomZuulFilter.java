package com.demo.app.gateway;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class CustomZuulFilter extends ZuulFilter {

	Logger logger = LoggerFactory.getLogger(CustomZuulFilter.class);

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();
		logger.info("custom log : ", httpServletRequest.getRequestURL());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
