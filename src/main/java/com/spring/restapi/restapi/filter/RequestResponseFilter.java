package com.spring.restapi.restapi.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestResponseFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        System.out.println( "Logging Request: " + req.getMethod() + req.getRequestURI() + " <--------------- Method Mapping");

        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Logging Response: " + res.getContentType() + " <--------------- Header Type");
    }
}
