package com.spring.restapi.restapi.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

@Component
public class TransactionFilter implements Filter {

    Logger logger;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;

        System.out.println("Starting a transaction for req : localhost:8080 " + req.getRequestURI());


        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Committing a transaction for req : localhost:8080" +  req.getRequestURI());
    }
}
