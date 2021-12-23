package com.curtis.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;


/**
 * @author curtis.cai
 * @desc TODO
 * @date 2021-12-23
 * @email curtis.cai@outlook.com
 * @reference
 */
@Component
public class PostZuulFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostZuulFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
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
        LOGGER.info("这是后置Zuul过滤器");
        RequestContext requestContext = RequestContext.getCurrentContext();
        requestContext.getResponse().setContentType(MediaType.APPLICATION_JSON_VALUE);
        requestContext.getResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
        String responseBody = requestContext.getResponseBody();
        if (StringUtils.isBlank(responseBody)) {
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            requestContext.setResponseBody(responseBody);
        }
        return null;
    }
}
