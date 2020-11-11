package com.carsonlius.boot.interceptor;

import com.carsonlius.boot.model.SystemLogDetails;
import com.carsonlius.boot.service.TestFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor implements HandlerInterceptor {
    // 手动注入，否则因为加载顺序的原因无法注入
    @Autowired
    private TestFilterService testFilterService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入前置拦截器");

        testFilterService.printFlag("拦截器");

        SystemLogDetails systemLogDetails = (SystemLogDetails)request
                .getSession()
                .getAttribute("log");
        System.out.println("请求日志"+ systemLogDetails);
        if (systemLogDetails == null) {
            System.out.println("没有通过日志拦截器");
           response.sendRedirect(request.getContextPath() + "/errorJsp");
            // false表示当前请求结束
           return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // preHandle返回值为true，才会执行这个方法
        System.out.println("拦截器postHandle preHandle返回值为true，才会执行这个方法");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器afterCompletion preHandle返回值为true，才会执行这个方法");
    }
}
