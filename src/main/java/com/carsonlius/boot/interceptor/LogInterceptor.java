package com.carsonlius.boot.interceptor;

import com.carsonlius.boot.model.SystemLogDetails;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SystemLogDetails systemLogDetails = (SystemLogDetails)request
                .getSession()
                .getAttribute("log");
        System.out.println("请求日志"+ systemLogDetails);
        if (systemLogDetails == null) {
            System.out.println("没有通过日志拦截器");
           response.sendRedirect(request.getContextPath() + "/errorJsp");
           return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
