package com.angel.apizuulproxyservice.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
public class PostFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletResponse httpServletResponse = context.getResponse();

        if(httpServletResponse.containsHeader("AUTH_HEADER")) {
            log.error("AUTH_HEADER present in Response headers");
        } else {
            context.addZuulResponseHeader("AUTH_HEADER_RESPONSE", UUID.randomUUID().toString());
            log.error("Added AUTH_HEADER_RESPONSE in HttpServletResponse");
        }

        return null;
    }
}
