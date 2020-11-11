package com.carsonlius.boot.filter;

import com.carsonlius.boot.service.TestFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/log/*")
@Order(value = 1)
public class LogFilter implements Filter {
    @Autowired
    private TestFilterService testFilterService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器前置 init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器处理中 doFilter方法");
        testFilterService.printFlag("过滤器");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁后置 destroy");
    }
}
