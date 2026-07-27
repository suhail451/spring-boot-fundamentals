package com.filterPractice.filterPractice.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class APIresponceTimeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        long startTime=System.currentTimeMillis();

        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;

        filterChain.doFilter(httpServletRequest,httpServletResponse);

        long duration=System.currentTimeMillis()-startTime;
        System.out.println("Response Status"+
                httpServletResponse.getStatus()+
                "\nResponce Time is "+duration);



    }
}
