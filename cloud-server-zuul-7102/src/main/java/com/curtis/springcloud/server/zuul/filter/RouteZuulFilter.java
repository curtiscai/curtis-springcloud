package com.curtis.springcloud.server.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;


/**
 * @author curtis.cai
 * @desc TODO
 * @date 2021-12-23
 * @email curtis.cai@outlook.com
 * @reference
 */
@Component
public class RouteZuulFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteZuulFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
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
        LOGGER.info("这是路由Zuul过滤器");
        return null;
    }
}
