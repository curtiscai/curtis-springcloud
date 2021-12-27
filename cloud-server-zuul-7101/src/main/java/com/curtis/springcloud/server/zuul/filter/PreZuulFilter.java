package com.curtis.springcloud.server.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


/**
 * @author curtis.cai
 * @desc TODO
 * @date 2021-12-23
 * @email curtis.cai@outlook.com
 * @reference
 */
@Component
public class PreZuulFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PreZuulFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        LOGGER.info("这是第一个前置Zuul过滤器");
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        String authStr = httpServletRequest.getParameter("auth");
        if (StringUtils.isBlank(authStr)) {
            requestContext.setSendZuulResponse(false);
            // requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            String responseStr = "{\"code\":\"401\",\"data\":null,\"msg\":\"授权失败\"}";
            requestContext.setResponseBody(responseStr);
        }
        return null;
    }
}
