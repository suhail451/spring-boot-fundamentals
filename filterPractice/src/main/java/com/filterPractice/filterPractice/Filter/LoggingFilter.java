package com.filterPractice.filterPractice.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class LoggingFilter implements Filter {


    private final HttpServletResponse httpServletResponse;

    public LoggingFilter(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        System.out.println("Logging "+httpRequest.getHttpServletMapping()+"\n"+
                httpRequest.getMethod()+"\n"+
                httpRequest.getRequestURI());

        filterChain.doFilter(httpRequest,httpResponse);

    }




}
