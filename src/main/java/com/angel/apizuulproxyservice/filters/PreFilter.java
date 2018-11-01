package com.angel.apizuulproxyservice.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Slf4j
public class PreFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
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
    public Object run() throws ZuulException {
//        RequestContext object from the zuul library enables us to take the HttpServletRequest
//        and check whether or not the request contains some data like Auth header
//        or add the header if it is missing and it forwards the request to the services downstream with the added header
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        if(request.getAttribute("AUTH_HEADER") == null){
            context.addZuulRequestHeader("AUTH_HEADER", UUID.randomUUID().toString());
            log.error("Added header AUTH_HEADER");
        }

        return null;
    }
}
